package com.lzh.commonframe.moudle.blog.domain;

import com.lzh.commonframe.common.domain.CommonArticle;
import com.lzh.commonframe.common.domain.CommonArticleSort;
import com.lzh.commonframe.common.domain.CommonBlogSort;

public class ArticleDTO {

    private CommonArticle article;

    private CommonArticleSort article_sort;

    private CommonBlogSort blog_sort;

    public CommonArticle getArticle() {
        return article;
    }

    public void setArticle(CommonArticle article) {
        this.article = article;
    }

    public CommonArticleSort getArticle_sort() {
        return article_sort;
    }

    public void setArticle_sort(CommonArticleSort article_sort) {
        this.article_sort = article_sort;
    }

    public CommonBlogSort getBlog_sort() {
        return blog_sort;
    }

    public void setBlog_sort(CommonBlogSort blog_sort) {
        this.blog_sort = blog_sort;
    }
}
