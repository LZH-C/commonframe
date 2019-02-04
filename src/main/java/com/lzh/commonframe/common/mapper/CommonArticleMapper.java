package com.lzh.commonframe.common.mapper;

import com.lzh.commonframe.common.domain.CommonArticle;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

@Mapper
public interface CommonArticleMapper {
    @Delete({
        "delete from article",
        "where article_id = #{articleId,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer articleId);

    @Insert({
        "insert into article (article_id, article_name, ",
        "article_time, article_ip, ",
        "article_click, sort_article_id, ",
        "sort_bolg_id, user_id, ",
        "type_id, article_type, ",
        "article_up, article_support, ",
        "article_status, article_content)",
        "values (#{articleId,jdbcType=INTEGER}, #{articleName,jdbcType=VARCHAR}, ",
        "#{articleTime,jdbcType=TIMESTAMP}, #{articleIp,jdbcType=VARCHAR}, ",
        "#{articleClick,jdbcType=INTEGER}, #{sortArticleId,jdbcType=INTEGER}, ",
        "#{sortBolgId,jdbcType=INTEGER}, #{userId,jdbcType=INTEGER}, ",
        "#{typeId,jdbcType=TINYINT}, #{articleType,jdbcType=INTEGER}, ",
        "#{articleUp,jdbcType=TINYINT}, #{articleSupport,jdbcType=TINYINT}, ",
        "#{articleStatus,jdbcType=TINYINT}, #{articleContent,jdbcType=LONGVARCHAR})"
    })
    int insert(CommonArticle record);

    @InsertProvider(type=CommonArticleSqlProvider.class, method="insertSelective")
    int insertSelective(CommonArticle record);

    @Select({
        "select",
        "article_id, article_name, article_time, article_ip, article_click, sort_article_id, ",
        "sort_bolg_id, user_id, type_id, article_type, article_up, article_support, article_status, ",
        "article_content",
        "from article",
        "where article_id = #{articleId,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="article_id", property="articleId", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="article_name", property="articleName", jdbcType=JdbcType.VARCHAR),
        @Result(column="article_time", property="articleTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="article_ip", property="articleIp", jdbcType=JdbcType.VARCHAR),
        @Result(column="article_click", property="articleClick", jdbcType=JdbcType.INTEGER),
        @Result(column="sort_article_id", property="sortArticleId", jdbcType=JdbcType.INTEGER),
        @Result(column="sort_bolg_id", property="sortBolgId", jdbcType=JdbcType.INTEGER),
        @Result(column="user_id", property="userId", jdbcType=JdbcType.INTEGER),
        @Result(column="type_id", property="typeId", jdbcType=JdbcType.TINYINT),
        @Result(column="article_type", property="articleType", jdbcType=JdbcType.INTEGER),
        @Result(column="article_up", property="articleUp", jdbcType=JdbcType.TINYINT),
        @Result(column="article_support", property="articleSupport", jdbcType=JdbcType.TINYINT),
        @Result(column="article_status", property="articleStatus", jdbcType=JdbcType.TINYINT),
        @Result(column="article_content", property="articleContent", jdbcType=JdbcType.LONGVARCHAR)
    })
    CommonArticle selectByPrimaryKey(Integer articleId);

    @UpdateProvider(type=CommonArticleSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(CommonArticle record);

    @Update({
        "update article",
        "set article_name = #{articleName,jdbcType=VARCHAR},",
          "article_time = #{articleTime,jdbcType=TIMESTAMP},",
          "article_ip = #{articleIp,jdbcType=VARCHAR},",
          "article_click = #{articleClick,jdbcType=INTEGER},",
          "sort_article_id = #{sortArticleId,jdbcType=INTEGER},",
          "sort_bolg_id = #{sortBolgId,jdbcType=INTEGER},",
          "user_id = #{userId,jdbcType=INTEGER},",
          "type_id = #{typeId,jdbcType=TINYINT},",
          "article_type = #{articleType,jdbcType=INTEGER},",
          "article_up = #{articleUp,jdbcType=TINYINT},",
          "article_support = #{articleSupport,jdbcType=TINYINT},",
          "article_status = #{articleStatus,jdbcType=TINYINT},",
          "article_content = #{articleContent,jdbcType=LONGVARCHAR}",
        "where article_id = #{articleId,jdbcType=INTEGER}"
    })
    int updateByPrimaryKeyWithBLOBs(CommonArticle record);

    @Update({
        "update article",
        "set article_name = #{articleName,jdbcType=VARCHAR},",
          "article_time = #{articleTime,jdbcType=TIMESTAMP},",
          "article_ip = #{articleIp,jdbcType=VARCHAR},",
          "article_click = #{articleClick,jdbcType=INTEGER},",
          "sort_article_id = #{sortArticleId,jdbcType=INTEGER},",
          "sort_bolg_id = #{sortBolgId,jdbcType=INTEGER},",
          "user_id = #{userId,jdbcType=INTEGER},",
          "type_id = #{typeId,jdbcType=TINYINT},",
          "article_type = #{articleType,jdbcType=INTEGER},",
          "article_up = #{articleUp,jdbcType=TINYINT},",
          "article_support = #{articleSupport,jdbcType=TINYINT},",
          "article_status = #{articleStatus,jdbcType=TINYINT}",
        "where article_id = #{articleId,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(CommonArticle record);
}