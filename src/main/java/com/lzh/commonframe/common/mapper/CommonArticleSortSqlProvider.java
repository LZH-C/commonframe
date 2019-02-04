package com.lzh.commonframe.common.mapper;

import static org.apache.ibatis.jdbc.SqlBuilder.BEGIN;
import static org.apache.ibatis.jdbc.SqlBuilder.INSERT_INTO;
import static org.apache.ibatis.jdbc.SqlBuilder.SET;
import static org.apache.ibatis.jdbc.SqlBuilder.SQL;
import static org.apache.ibatis.jdbc.SqlBuilder.UPDATE;
import static org.apache.ibatis.jdbc.SqlBuilder.VALUES;
import static org.apache.ibatis.jdbc.SqlBuilder.WHERE;

import com.lzh.commonframe.common.domain.CommonArticleSort;

public class CommonArticleSortSqlProvider {

    public String insertSelective(CommonArticleSort record) {
        BEGIN();
        INSERT_INTO("article_sort");
        
        if (record.getSortArticleId() != null) {
            VALUES("sort_article_id", "#{sortArticleId,jdbcType=INTEGER}");
        }
        
        if (record.getSortArticleName() != null) {
            VALUES("sort_article_name", "#{sortArticleName,jdbcType=VARCHAR}");
        }
        
        return SQL();
    }

    public String updateByPrimaryKeySelective(CommonArticleSort record) {
        BEGIN();
        UPDATE("article_sort");
        
        if (record.getSortArticleName() != null) {
            SET("sort_article_name = #{sortArticleName,jdbcType=VARCHAR}");
        }
        
        WHERE("sort_article_id = #{sortArticleId,jdbcType=INTEGER}");
        
        return SQL();
    }
}