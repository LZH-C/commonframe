package com.lzh.commonframe.common.mapper;

import com.lzh.commonframe.common.domain.CommonBlogSort;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

@Mapper
public interface CommonBlogSortMapper {
    @Delete({
        "delete from blog_sort",
        "where sort_blog_id = #{sortBlogId,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer sortBlogId);

    @Insert({
        "insert into blog_sort (sort_blog_id, sort_blog_name)",
        "values (#{sortBlogId,jdbcType=INTEGER}, #{sortBlogName,jdbcType=VARCHAR})"
    })
    int insert(CommonBlogSort record);

    @InsertProvider(type=CommonBlogSortSqlProvider.class, method="insertSelective")
    int insertSelective(CommonBlogSort record);

    @Select({
        "select",
        "sort_blog_id, sort_blog_name",
        "from blog_sort",
        "where sort_blog_id = #{sortBlogId,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="sort_blog_id", property="sortBlogId", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="sort_blog_name", property="sortBlogName", jdbcType=JdbcType.VARCHAR)
    })
    CommonBlogSort selectByPrimaryKey(Integer sortBlogId);

    @UpdateProvider(type=CommonBlogSortSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(CommonBlogSort record);

    @Update({
        "update blog_sort",
        "set sort_blog_name = #{sortBlogName,jdbcType=VARCHAR}",
        "where sort_blog_id = #{sortBlogId,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(CommonBlogSort record);
}