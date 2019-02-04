package com.lzh.commonframe.moudle.blog.service;

import com.lzh.commonframe.common.domain.*;
import com.lzh.commonframe.moudle.blog.domain.ArticleListItemDTO;
import com.lzh.commonframe.moudle.blog.domain.UpdateArticleMsgDTO;
import com.lzh.commonframe.moudle.blog.domain.smiditorResult;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface BlogService {

    /*添加文章*/
    ResponseDTO addArticle(CommonArticle articleDTO);

    /*获取文章总数*/
    int getArticleNum();

    /*查看文章*/
    ResponseDTO getArticle(SearchDTO dto);

    /*修改文章*/
    ResponseDTO upDateArticle(UpdateArticleMsgDTO articleDTO);

    /*文章图片的上传*/
    smiditorResult UploadImg(MultipartFile file) throws IOException;

    /*更改文章状态 0正常 1草稿 2冻结 3回收站*/
    ResponseDTO changeArticle(int articleId,byte status);

    /*删除文章*/
    ResponseDTO delArticle(CommonArticle article);

    /*获取ArticleSort列表*/
    List<CommonArticleSort> getArticleSort();

    /*获取BlogSort列表*/
    List<CommonBlogSort> getBlogSort();

    /*获取文章列表内容,按时间倒序排列，根据页面取值*/
    List<ArticleListItemDTO> getListArticle(SearchDTO dto);

    /*获取文章列表内容,按时间倒序排列，根据userId取值*/
    List<ArticleListItemDTO> getListArticleByUserId(SearchDTO dto);

    /*获取文章列表内容,按时间倒序排列，根据关键字取值*/
    List<ArticleListItemDTO> getListArticleByKeyWord(SearchDTO dto);

}
