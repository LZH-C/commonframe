package com.lzh.commonframe.common.mapper;

import com.lzh.commonframe.common.domain.CommonArticleSort;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

@Mapper
public interface CommonArticleSortMapper {
    @Delete({
        "delete from article_sort",
        "where sort_article_id = #{sortArticleId,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer sortArticleId);

    @Insert({
        "insert into article_sort (sort_article_id, sort_article_name)",
        "values (#{sortArticleId,jdbcType=INTEGER}, #{sortArticleName,jdbcType=VARCHAR})"
    })
    int insert(CommonArticleSort record);

    @InsertProvider(type=CommonArticleSortSqlProvider.class, method="insertSelective")
    int insertSelective(CommonArticleSort record);

    @Select({
        "select",
        "sort_article_id, sort_article_name",
        "from article_sort",
        "where sort_article_id = #{sortArticleId,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="sort_article_id", property="sortArticleId", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="sort_article_name", property="sortArticleName", jdbcType=JdbcType.VARCHAR)
    })
    CommonArticleSort selectByPrimaryKey(Integer sortArticleId);

    @UpdateProvider(type=CommonArticleSortSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(CommonArticleSort record);

    @Update({
        "update article_sort",
        "set sort_article_name = #{sortArticleName,jdbcType=VARCHAR}",
        "where sort_article_id = #{sortArticleId,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(CommonArticleSort record);
}