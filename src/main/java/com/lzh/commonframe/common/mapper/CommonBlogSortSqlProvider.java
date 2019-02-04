package com.lzh.commonframe.common.mapper;

import static org.apache.ibatis.jdbc.SqlBuilder.BEGIN;
import static org.apache.ibatis.jdbc.SqlBuilder.INSERT_INTO;
import static org.apache.ibatis.jdbc.SqlBuilder.SET;
import static org.apache.ibatis.jdbc.SqlBuilder.SQL;
import static org.apache.ibatis.jdbc.SqlBuilder.UPDATE;
import static org.apache.ibatis.jdbc.SqlBuilder.VALUES;
import static org.apache.ibatis.jdbc.SqlBuilder.WHERE;

import com.lzh.commonframe.common.domain.CommonBlogSort;

public class CommonBlogSortSqlProvider {

    public String insertSelective(CommonBlogSort record) {
        BEGIN();
        INSERT_INTO("blog_sort");
        
        if (record.getSortBlogId() != null) {
            VALUES("sort_blog_id", "#{sortBlogId,jdbcType=INTEGER}");
        }
        
        if (record.getSortBlogName() != null) {
            VALUES("sort_blog_name", "#{sortBlogName,jdbcType=VARCHAR}");
        }
        
        return SQL();
    }

    public String updateByPrimaryKeySelective(CommonBlogSort record) {
        BEGIN();
        UPDATE("blog_sort");
        
        if (record.getSortBlogName() != null) {
            SET("sort_blog_name = #{sortBlogName,jdbcType=VARCHAR}");
        }
        
        WHERE("sort_blog_id = #{sortBlogId,jdbcType=INTEGER}");
        
        return SQL();
    }
}