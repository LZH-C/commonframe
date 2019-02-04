package com.lzh.commonframe.moudle.blog.domain;

import com.lzh.commonframe.common.domain.CommonArticleSort;
import com.lzh.commonframe.common.domain.CommonBlogSort;

import java.util.List;

public class BlogSelectSort {

    private List<CommonArticleSort> articleSort;

    private List<CommonBlogSort> blogSort;

    public List<CommonArticleSort> getArticleSort() {
        return articleSort;
    }

    public void setArticleSort(List<CommonArticleSort> articleSort) {
        this.articleSort = articleSort;
    }

    public List<CommonBlogSort> getBlogSort() {
        return blogSort;
    }

    public void setBlogSort(List<CommonBlogSort> blogSort) {
        this.blogSort = blogSort;
    }
}