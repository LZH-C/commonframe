package com.lzh.commonframe.common.mapper;

import static org.apache.ibatis.jdbc.SqlBuilder.BEGIN;
import static org.apache.ibatis.jdbc.SqlBuilder.INSERT_INTO;
import static org.apache.ibatis.jdbc.SqlBuilder.SET;
import static org.apache.ibatis.jdbc.SqlBuilder.SQL;
import static org.apache.ibatis.jdbc.SqlBuilder.UPDATE;
import static org.apache.ibatis.jdbc.SqlBuilder.VALUES;
import static org.apache.ibatis.jdbc.SqlBuilder.WHERE;

import com.lzh.commonframe.common.domain.CommonArticle;

public class CommonArticleSqlProvider {

    public String insertSelective(CommonArticle record) {
        BEGIN();
        INSERT_INTO("article");
        
        if (record.getArticleId() != null) {
            VALUES("article_id", "#{articleId,jdbcType=INTEGER}");
        }
        
        if (record.getArticleName() != null) {
            VALUES("article_name", "#{articleName,jdbcType=VARCHAR}");
        }
        
        if (record.getArticleTime() != null) {
            VALUES("article_time", "#{articleTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getArticleIp() != null) {
            VALUES("article_ip", "#{articleIp,jdbcType=VARCHAR}");
        }
        
        if (record.getArticleClick() != null) {
            VALUES("article_click", "#{articleClick,jdbcType=INTEGER}");
        }
        
        if (record.getSortArticleId() != null) {
            VALUES("sort_article_id", "#{sortArticleId,jdbcType=INTEGER}");
        }
        
        if (record.getSortBolgId() != null) {
            VALUES("sort_bolg_id", "#{sortBolgId,jdbcType=INTEGER}");
        }
        
        if (record.getUserId() != null) {
            VALUES("user_id", "#{userId,jdbcType=INTEGER}");
        }
        
        if (record.getTypeId() != null) {
            VALUES("type_id", "#{typeId,jdbcType=TINYINT}");
        }
        
        if (record.getArticleType() != null) {
            VALUES("article_type", "#{articleType,jdbcType=INTEGER}");
        }
        
        if (record.getArticleUp() != null) {
            VALUES("article_up", "#{articleUp,jdbcType=TINYINT}");
        }
        
        if (record.getArticleSupport() != null) {
            VALUES("article_support", "#{articleSupport,jdbcType=TINYINT}");
        }
        
        if (record.getArticleStatus() != null) {
            VALUES("article_status", "#{articleStatus,jdbcType=TINYINT}");
        }
        
        if (record.getArticleContent() != null) {
            VALUES("article_content", "#{articleContent,jdbcType=LONGVARCHAR}");
        }
        
        return SQL();
    }

    public String updateByPrimaryKeySelective(CommonArticle record) {
        BEGIN();
        UPDATE("article");
        
        if (record.getArticleName() != null) {
            SET("article_name = #{articleName,jdbcType=VARCHAR}");
        }
        
        if (record.getArticleTime() != null) {
            SET("article_time = #{articleTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getArticleIp() != null) {
            SET("article_ip = #{articleIp,jdbcType=VARCHAR}");
        }
        
        if (record.getArticleClick() != null) {
            SET("article_click = #{articleClick,jdbcType=INTEGER}");
        }
        
        if (record.getSortArticleId() != null) {
            SET("sort_article_id = #{sortArticleId,jdbcType=INTEGER}");
        }
        
        if (record.getSortBolgId() != null) {
            SET("sort_bolg_id = #{sortBolgId,jdbcType=INTEGER}");
        }
        
        if (record.getUserId() != null) {
            SET("user_id = #{userId,jdbcType=INTEGER}");
        }
        
        if (record.getTypeId() != null) {
            SET("type_id = #{typeId,jdbcType=TINYINT}");
        }
        
        if (record.getArticleType() != null) {
            SET("article_type = #{articleType,jdbcType=INTEGER}");
        }
        
        if (record.getArticleUp() != null) {
            SET("article_up = #{articleUp,jdbcType=TINYINT}");
        }
        
        if (record.getArticleSupport() != null) {
            SET("article_support = #{articleSupport,jdbcType=TINYINT}");
        }
        
        if (record.getArticleStatus() != null) {
            SET("article_status = #{articleStatus,jdbcType=TINYINT}");
        }
        
        if (record.getArticleContent() != null) {
            SET("article_content = #{articleContent,jdbcType=LONGVARCHAR}");
        }
        
        WHERE("article_id = #{articleId,jdbcType=INTEGER}");
        
        return SQL();
    }
}