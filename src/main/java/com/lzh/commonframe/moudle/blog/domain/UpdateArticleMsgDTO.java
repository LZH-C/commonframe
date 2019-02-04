package com.lzh.commonframe.moudle.blog.domain;

import java.util.Date;

public class UpdateArticleMsgDTO {

    //文章id
    private Integer articleId;

    //文章名称
    private String articleName;

    //文章类型id
    private Integer sortArticleId;

    //博客类型id
    private Integer sortBlogId;

    //文章内容
    private String articleContent;

    //更新时间
    private Date articleTime;

    public Integer getArticleId() {
        return articleId;
    }

    public void setArticleId(Integer articleId) {
        this.articleId = articleId;
    }

    public String getArticleName() {
        return articleName;
    }

    public void setArticleName(String articleName) {
        this.articleName = articleName;
    }

    public Integer getSortArticleId() {
        return sortArticleId;
    }

    public void setSortArticleId(Integer sortArticleId) {
        this.sortArticleId = sortArticleId;
    }

    public Integer getSortBlogId() {
        return sortBlogId;
    }

    public void setSortBlogId(Integer sortBlogId) {
        this.sortBlogId = sortBlogId;
    }

    public String getArticleContent() {
        return articleContent;
    }

    public void setArticleContent(String articleContent) {
        this.articleContent = articleContent;
    }

    public Date getArticleTime() {
        return articleTime;
    }

    public void setArticleTime(Date articleTime) {
        this.articleTime = articleTime;
    }
}
