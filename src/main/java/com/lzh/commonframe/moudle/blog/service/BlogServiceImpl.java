package com.lzh.commonframe.moudle.blog.service;

import com.lzh.commonframe.common.domain.*;
import com.lzh.commonframe.common.mapper.CommonArticleMapper;
import com.lzh.commonframe.common.mapper.CommonArticleSortMapper;
import com.lzh.commonframe.common.mapper.CommonBlogSortMapper;
import com.lzh.commonframe.moudle.blog.domain.ArticleListItemDTO;
import com.lzh.commonframe.moudle.blog.domain.UpdateArticleMsgDTO;
import com.lzh.commonframe.moudle.blog.domain.smiditorResult;
import com.lzh.commonframe.moudle.blog.mapper.BlogMapper;
import com.lzh.commonframe.moudle.user.mapper.UserMapper;
import com.lzh.commonframe.util.FTPUtil;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;

@Service
public class BlogServiceImpl implements BlogService {

    @Autowired
    CommonArticleMapper articleMapper;
    @Autowired
    CommonArticleSortMapper article_sortMapper;
    @Autowired
    CommonBlogSortMapper blog_sortMapper;
    @Autowired
    BlogMapper blogMapper;
    @Autowired
    UserMapper userMapper;

    /*添加文章*/
    @Override
    public ResponseDTO addArticle(CommonArticle articleDTO){
        try {
            articleDTO.setUserId((int)SecurityUtils.getSubject().getSession().getAttribute("userId"));
            //articleDTO.setTypeId();//添加栏目ID
            int i = articleMapper.insertSelective(articleDTO);
            if(i==1) {
                return ResponseDTO.succData("添加文章成功");
            }else{
                return ResponseDTO.succData("添加文章失败");
            }
        }catch(Exception e){
            e.printStackTrace();
            return ResponseDTO.succData("添加文章失败");
        }
    }

    @Override
    public ResponseDTO upDateArticle(UpdateArticleMsgDTO articleDTO) {
        articleDTO.setArticleTime(new Date());
        int i= blogMapper.updateByPrimaryKeySelective(articleDTO);
        if(i==1){
            return ResponseDTO.succData("修改文章成功");
        }else{
            return  ResponseDTO.errorData("修改文章失败");
        }
    }

    /*文章图片的上传*/
    @Override
    public smiditorResult UploadImg(MultipartFile file) throws IOException {
        if(file.isEmpty()){
            System.out.println("上传失败");
            return new smiditorResult("null",false,"上传失败");
        }

        if (file!=null) {// 判断上传的文件是否为空

            String type = null;// 文件类型
            String fileName = file.getOriginalFilename();// 文件原名称
            System.out.println("上传的文件原名称:"+fileName);
            // 判断文件类型
            type = fileName.indexOf(".")!=-1?fileName.substring(fileName.lastIndexOf(".")+1, fileName.length()):null;
            if (type!=null) {// 判断文件类型是否为空
                if ("GIF".equals(type.toUpperCase())||"PNG".equals(type.toUpperCase())||"JPG".equals(type.toUpperCase())) {
                    // 项目在容器中实际发布运行的根路径
                    String realPath = "http://182.61.55.14/imageLoad/";
                    // 自定义的文件名称
                    String trueFileName = String.valueOf(System.currentTimeMillis()) + "." + type;
                    // 设置存放图片文件的路径
                    String path=realPath+trueFileName;
                    System.out.println("存放图片文件的路径:"+path);
                    InputStream inputStream = file.getInputStream();
                    boolean flag = FTPUtil.uploadFile("182.61.55.14", 21, "ftpuser", "2282924", "/data/ftp","/imageLoad", trueFileName, inputStream);
                    if(flag){
                        System.out.println("上传成功！");
                        return new smiditorResult(path,true,"文件成功上传到指定目录下");
                    }else{
                        return new smiditorResult("null",false,"上传失败");
                    }
                }else {
                    return new smiditorResult("null",false,"不是我们想要的文件类型,请按要求重新上传");
                }
            }else {
                return new smiditorResult("null",false,"文件类型为空");
            }
        }else {
            return new smiditorResult("null",false,"没有找到相对应的文件");
        }
    }

    /*查看文章内容*/
    @Override
    public ResponseDTO getArticle(SearchDTO dto) {
        ArticleListItemDTO article=blogMapper.getArticle(dto);
        article.setArticleClick(article.getArticleClick()+1);
        CommonArticle article1AddClick=new CommonArticle();
        article1AddClick.setArticleId(article.getArticleId());
        article1AddClick.setArticleClick(article.getArticleClick());
        int i=articleMapper.updateByPrimaryKeySelective(article1AddClick);
        if(i!=0){
            return new ResponseDTO("成功返回",article);
        }else {
            return ResponseDTO.errorData("成功返回");
        }

    }

    /*文章状态 0正常 1草稿 2冻结 3回收站*/
    @Override
    public ResponseDTO changeArticle(int articleId,byte status) {
        CommonArticle article=new CommonArticle();
        article.setArticleId(articleId);
        article.setArticleStatus(status);
        int i=articleMapper.updateByPrimaryKeySelective(article);
        if(i==1){
            return ResponseDTO.succData("文章状态改变成功");
        }else{
            return  ResponseDTO.succData("文章状态改变失败");
        }
    }

    @Override
    public ResponseDTO delArticle(CommonArticle article) {
        article.setUserId((int)SecurityUtils.getSubject().getSession().getAttribute("userId"));
        int i=blogMapper.deleteArticle(article);
        if(i==1){
            return ResponseDTO.succData("删除文章成功");
        }else{
            return ResponseDTO.errorData("删除文章失败");
        }
    }

    @Override
    public List<CommonArticleSort> getArticleSort() {
        return blogMapper.getArticleSort();
    }

    @Override
    public List<CommonBlogSort> getBlogSort() {
        return blogMapper.getBlogSort();
    }

    /*获取文章列表内容,按时间倒序排列，根据页面取值*/
    @Override
    public List<ArticleListItemDTO> getListArticle(SearchDTO dto){
        List<ArticleListItemDTO> articles = blogMapper.getListArticle(dto);
        int articleNum=blogMapper.getArticleNum();
        for(ArticleListItemDTO article:articles){
            article.setCommentNum(blogMapper.getCommentNum(article.getArticleId()));
            article.setArticleNum(articleNum);
        }
        return articles;
    }

    @Override
    public List<ArticleListItemDTO> getListArticleByUserId(SearchDTO dto) {
        dto.setId(userMapper.findByName(dto.getAssociateString()).getUserId());
        List<ArticleListItemDTO> articles = blogMapper.getListArticleByUserId(dto);
        for(ArticleListItemDTO article:articles){
            article.setCommentNum(blogMapper.getCommentNum(article.getArticleId()));
        }
        return articles;
    }

    @Override
    public List<ArticleListItemDTO> getListArticleByKeyWord(SearchDTO dto) {
        return blogMapper.getListArticleByKeyWord(dto);
    }

    @Override
    public int getArticleNum() {
        return blogMapper.getArticleNum();
    }
}
