package com.lzh.commonframe.moudle.blog.domain;

import java.util.Date;

public class ArticleListItemDTO {
    private Integer articleId;

    private String articleName;

    private Date articleTime;

    private Integer articleClick;

    private String sortArticleName;

    private String sortBolgName;

    private String userName;

    private String articleContent;

    private int commentNum;

    private int articleNum;

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

    public Date getArticleTime() {
        return articleTime;
    }

    public void setArticleTime(Date articleTime) {
        this.articleTime = articleTime;
    }

    public Integer getArticleClick() {
        return articleClick;
    }

    public void setArticleClick(Integer articleClick) {
        this.articleClick = articleClick;
    }

    public String getSortArticleName() {
        return sortArticleName;
    }

    public void setSortArticleName(String sortArticleName) {
        this.sortArticleName = sortArticleName;
    }

    public String getSortBolgName() {
        return sortBolgName;
    }

    public void setSortBolgName(String sortBolgName) {
        this.sortBolgName = sortBolgName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getArticleContent() {
        return articleContent;
    }

    public void setArticleContent(String articleContent) {
        this.articleContent = articleContent;
    }

    public int getCommentNum() {
        return commentNum;
    }

    public void setCommentNum(int commentNum) {
        this.commentNum = commentNum;
    }

    public int getArticleNum() {
        return articleNum;
    }

    public void setArticleNum(int articleNum) {
        this.articleNum = articleNum;
    }
}
