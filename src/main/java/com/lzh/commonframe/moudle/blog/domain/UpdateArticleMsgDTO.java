package com.lzh.commonframe.moudle.blog.domain;

public class UpdateArticleMsgDTO {

    //文章id
    private Short articleId;

    //文章名称
    private String articleName;

    //文章类型id
    private Integer sortArticleId;

    //博客类型id
    private Integer sortBolgId;

    //文章内容
    private String articleContent;

    public Short getArticleId() {
        return articleId;
    }

    public void setArticleId(Short articleId) {
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

    public Integer getSortBolgId() {
        return sortBolgId;
    }

    public void setSortBolgId(Integer sortBolgId) {
        this.sortBolgId = sortBolgId;
    }

    public String getArticleContent() {
        return articleContent;
    }

    public void setArticleContent(String articleContent) {
        this.articleContent = articleContent;
    }
}
