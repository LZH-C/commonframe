package com.lzh.commonframe.moudle.blog.controller;

import com.lzh.commonframe.common.domain.CommonArticle;
import com.lzh.commonframe.common.domain.ResponseDTO;
import com.lzh.commonframe.common.domain.SearchDTO;
import com.lzh.commonframe.config.shiro.manager.TokenManager;
import com.lzh.commonframe.moudle.blog.domain.*;
import com.lzh.commonframe.moudle.blog.service.BlogService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.io.*;
import java.util.Date;
import java.util.List;

@Api(tags = "博客controller")
@Controller
public class BolgController {

    @Autowired
    BlogService blogService;

    /*文章的上传*/
    @PostMapping("/article/new/submit")
    @ResponseBody
    public ResponseDTO addBlog(@Valid CommonArticle articleDTO, HttpServletRequest request){
        articleDTO.setArticleTime(new Date());
        articleDTO.setArticleIp(request.getRemoteAddr());
        return blogService.addArticle(articleDTO);
    }

    /*文章图片的上传*/
    @PostMapping("/article/smiditor/uploadSimditorImg")
    @ResponseBody
    public smiditorResult getUploadImg(MultipartFile file)throws IOException {
       return blogService.UploadImg(file);
    }

    /*查看文章内容*/
    @GetMapping("/article/details/{articleId}")
    @ResponseBody
    public ResponseDTO getArticle( @PathVariable int articleId){
        return blogService.getArticle(new SearchDTO(articleId,(byte)0));
    }

    /*更新文章内容*/
    @PostMapping("/article/update")
    @ResponseBody
    public ResponseDTO updateArticleMsg(UpdateArticleMsgDTO upDateArticle){
         return blogService.upDateArticle(upDateArticle);
    }

    /*改变文章状态 0正常 1冻结 2回收站*/
    @PostMapping("/article/changeArticle")
    @ResponseBody
    public ResponseDTO changeArticle(short articleId,byte status){
        return blogService.changeArticle(articleId,status);
    }

    /*删除文章*/
    @GetMapping("/article/delArticle/{articleId}")
    @ResponseBody
    public ResponseDTO delArticle(@PathVariable int articleId){
        CommonArticle commonArticle=new CommonArticle();
        commonArticle.setArticleId(articleId);
        return  blogService.delArticle(commonArticle);
    }

    /*获取ArticleSort列表*/
    @GetMapping("/article/selectSort")
    @ResponseBody
    public ResponseDTO getArticleSort() {
        BlogSelectSort selectSort=new BlogSelectSort();
        selectSort.setArticleSort(blogService.getArticleSort());
        selectSort.setBlogSort(blogService.getBlogSort());
        return new ResponseDTO("获取成功！",selectSort);
    }

    /*获取文章列表内容,按时间倒序排列，根据页面取值*/
    @GetMapping("/article/list/{begin}/{end}")
    @ResponseBody
    public ResponseDTO getListArticle(@PathVariable int begin,@PathVariable int end){
        SearchDTO dto = new SearchDTO();
        dto.setBegin(begin);
        dto.setEnd(end);
        List<ArticleListItemDTO> list=blogService.getListArticle(dto);
        return new ResponseDTO("获取成功！",list);
    }

    /*获取文章列表内容,按时间倒序排列，根据页面取值*/
    @GetMapping("/article/list/{keyword}")
    @ResponseBody
    public ResponseDTO getListArticle(@PathVariable String keyword){
        SearchDTO dto = new SearchDTO();
        dto.setAssociateString(keyword);
        List<ArticleListItemDTO> list=blogService.getListArticleByKeyWord(dto);
        return new ResponseDTO("获取成功！",list);
    }

    /*获取文章列表内容,按时间倒序排列，根据页面取值*/
    @GetMapping("/article/list")
    @ResponseBody
    public ResponseDTO getListArticleByUserName(HttpServletRequest request){
        String userName=request.getQueryString().replace("userName=","");
        SearchDTO dto = new SearchDTO();
        dto.setAssociateString(userName);
        List<ArticleListItemDTO> list=blogService.getListArticleByUserId(dto);
        return new ResponseDTO("获取成功！",list);
    }

}
