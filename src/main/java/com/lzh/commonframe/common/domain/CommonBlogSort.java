package com.lzh.commonframe.common.domain;

public class CommonBlogSort {
    private Integer sortBlogId;

    private String sortBlogName;

    public Integer getSortBlogId() {
        return sortBlogId;
    }

    public void setSortBlogId(Integer sortBlogId) {
        this.sortBlogId = sortBlogId;
    }

    public String getSortBlogName() {
        return sortBlogName;
    }

    public void setSortBlogName(String sortBlogName) {
        this.sortBlogName = sortBlogName == null ? null : sortBlogName.trim();
    }
}