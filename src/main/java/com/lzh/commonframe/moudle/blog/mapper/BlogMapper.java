package com.lzh.commonframe.moudle.blog.mapper;

import com.lzh.commonframe.common.domain.CommonArticle;
import com.lzh.commonframe.common.domain.CommonArticleSort;
import com.lzh.commonframe.common.domain.CommonBlogSort;
import com.lzh.commonframe.common.domain.SearchDTO;
import com.lzh.commonframe.moudle.blog.domain.ArticleDTO;
import com.lzh.commonframe.moudle.blog.domain.ArticleListItemDTO;
import com.lzh.commonframe.moudle.blog.domain.UpdateArticleMsgDTO;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

import java.util.List;

@Mapper
public interface BlogMapper {
    /*删除文章，根据articleId和userId*/
    @Delete({
            "delete from article",
            "where article_id = #{articleId,jdbcType=INTEGER} and user_id= #{userId,jdbcType=INTEGER}"
    })
    int deleteArticle(CommonArticle article);

    /*添加文章*/
    @Insert({
            "insert into article (article_name, ",
            "article_time, article_ip, ",
            "article_click, sort_article_id, ",
            "user_id, type_id, ",
            "article_type, article_up, ",
            "article_support, article_content)",
            "values (#{articleName,jdbcType=VARCHAR}, ",
            "#{articleTime,jdbcType=INTEGER}, #{articleIp,jdbcType=VARCHAR}, ",
            "#{articleClick,jdbcType=INTEGER}, #{sortArticleId,jdbcType=INTEGER}, ",
            "#{userId,jdbcType=INTEGER}, #{typeId,jdbcType=TINYINT}, ",
            "#{articleType,jdbcType=INTEGER}, #{articleUp,jdbcType=TINYINT}, ",
            "#{articleSupport,jdbcType=TINYINT}, #{articleContent,jdbcType=LONGVARCHAR})"
    })
    Boolean addArticle(ArticleDTO articleDTO);

    /*获取文章总数*/
    @Select("select count(*) from article")
    int getArticleNum();

    /*查看文章内容,根据文章状态和文章id*/
    @Select({
            "select atc.*,u.user_name from article atc,user u where atc.user_id=u.user_id and article_id = #{id,jdbcType=INTEGER} and article_status = #{status,jdbcType=TINYINT}"
    })
    @Results({
            @Result(column="article_id", property="articleId", jdbcType=JdbcType.INTEGER, id=true),
            @Result(column="article_name", property="articleName", jdbcType=JdbcType.VARCHAR),
            @Result(column="article_time", property="articleTime", jdbcType=JdbcType.INTEGER),
            @Result(column="article_click", property="articleClick", jdbcType=JdbcType.INTEGER),
            @Result(column="sort_article_id", property="sortArticleId", jdbcType=JdbcType.INTEGER),
            @Result(column="sort_bolg_id", property="sortBlogId", jdbcType=JdbcType.INTEGER),
            @Result(column="sort_article_name", property="sortArticleName", jdbcType=JdbcType.VARCHAR),
            @Result(column="sort_blog_name", property="sortBlogName", jdbcType=JdbcType.VARCHAR),
            @Result(column="user_name", property="userName", jdbcType=JdbcType.VARCHAR),
            @Result(column="article_content", property="articleContent", jdbcType=JdbcType.LONGVARCHAR)
    })
    ArticleListItemDTO getArticle(SearchDTO dto);

    /*更新文章内容*/
    @InsertProvider(type = BlogSqlProvider.class,method = "updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(UpdateArticleMsgDTO UpdateArticleMsgDTO);

    /*获取ArticleSort列表*/
    @Select("select * from article_sort")
    @Results({
            @Result(column="sort_article_id", property="sortArticleId", jdbcType=JdbcType.INTEGER, id=true),
            @Result(column="sort_article_name", property="sortArticleName", jdbcType=JdbcType.VARCHAR)
    })
    List<CommonArticleSort> getArticleSort();

    /*获取BlogSort列表*/
    @Select("select * from blog_sort")
    @Results({
            @Result(column="sort_blog_id", property="sortBlogId", jdbcType=JdbcType.INTEGER, id=true),
            @Result(column="sort_blog_name", property="sortBlogName", jdbcType=JdbcType.VARCHAR)
    })
    List<CommonBlogSort> getBlogSort();

    /*获取文章列表内容,按时间倒序排列，根据begin,end取值*/
    @Select({"select a.article_id,a.article_name,a.article_time,a.article_click,a.article_content,\n" +
            "asort.sort_article_name,bsort.sort_blog_name,u.user_name \n" +
            "from article a,user u,article_sort asort,blog_sort bsort \n" +
            "where a.user_id=u.user_id and a.sort_article_id=asort.sort_article_id \n" +
            "and a.sort_bolg_id=bsort.sort_blog_id ORDER BY a.article_time desc " +
            "LIMIT #{begin,jdbcType=INTEGER},#{end,jdbcType=INTEGER}"
    })
    @Results({
            @Result(column="article_id", property="articleId", jdbcType=JdbcType.INTEGER, id=true),
            @Result(column="article_name", property="articleName", jdbcType=JdbcType.VARCHAR),
            @Result(column="article_time", property="articleTime", jdbcType=JdbcType.INTEGER),
            @Result(column="article_click", property="articleClick", jdbcType=JdbcType.INTEGER),
            @Result(column="sort_article_name", property="sortArticleName", jdbcType=JdbcType.VARCHAR),
            @Result(column="sort_blog_name", property="sortBlogName", jdbcType=JdbcType.VARCHAR),
            @Result(column="user_name", property="userName", jdbcType=JdbcType.VARCHAR),
            @Result(column="article_content", property="articleContent", jdbcType=JdbcType.LONGVARCHAR)
    })
    List<ArticleListItemDTO> getListArticle(SearchDTO dto);

    /*获取文章列表内容,按时间倒序排列，根据关键字取值*/
    @Select({"select a.article_id,a.article_name,a.article_time,a.article_click,a.article_content,\n" +
            "asort.sort_article_name,bsort.sort_blog_name,u.user_name \n" +
            "from article a,user u,article_sort asort,blog_sort bsort \n" +
            "where a.user_id=u.user_id and a.sort_article_id=asort.sort_article_id \n" +
            "and a.sort_bolg_id=bsort.sort_blog_id and a.article_name like CONCAT('%',#{associateString,jdbcType=VARCHAR},'%')" +
            " ORDER BY a.article_time desc " +
            "LIMIT 0,10"
    })
    @Results({
            @Result(column="article_id", property="articleId", jdbcType=JdbcType.INTEGER, id=true),
            @Result(column="article_name", property="articleName", jdbcType=JdbcType.VARCHAR),
            @Result(column="article_time", property="articleTime", jdbcType=JdbcType.INTEGER),
            @Result(column="article_click", property="articleClick", jdbcType=JdbcType.INTEGER),
            @Result(column="sort_article_name", property="sortArticleName", jdbcType=JdbcType.VARCHAR),
            @Result(column="sort_blog_name", property="sortBlogName", jdbcType=JdbcType.VARCHAR),
            @Result(column="user_name", property="userName", jdbcType=JdbcType.VARCHAR),
            @Result(column="article_content", property="articleContent", jdbcType=JdbcType.LONGVARCHAR)
    })
    List<ArticleListItemDTO> getListArticleByKeyWord(SearchDTO dto);

    /*获取文章列表内容,按时间倒序排列，根据userId取值*/
    @Select({"select a.article_id,a.article_name,a.article_time,a.article_click,a.article_content,\n" +
            "asort.sort_article_name,bsort.sort_blog_name,u.user_name \n" +
            "from article a,user u,article_sort asort,blog_sort bsort \n" +
            "where a.user_id=u.user_id and a.sort_article_id=asort.sort_article_id \n" +
            "and a.sort_bolg_id=bsort.sort_blog_id and u.user_id=#{id,jdbcType=INTEGER} " +
            "ORDER BY a.article_time desc "
    })
    @Results({
            @Result(column="article_id", property="articleId", jdbcType=JdbcType.INTEGER, id=true),
            @Result(column="article_name", property="articleName", jdbcType=JdbcType.VARCHAR),
            @Result(column="article_time", property="articleTime", jdbcType=JdbcType.INTEGER),
            @Result(column="article_click", property="articleClick", jdbcType=JdbcType.INTEGER),
            @Result(column="sort_article_name", property="sortArticleName", jdbcType=JdbcType.VARCHAR),
            @Result(column="sort_blog_name", property="sortBlogName", jdbcType=JdbcType.VARCHAR),
            @Result(column="user_name", property="userName", jdbcType=JdbcType.VARCHAR),
            @Result(column="article_content", property="articleContent", jdbcType=JdbcType.LONGVARCHAR)
    })
    List<ArticleListItemDTO> getListArticleByUserId(SearchDTO dto);

    /*获取单个文章评论数*/
    @Select("select SUM(t.cnt) from (" +
            "select count(ct.comment_id) as cnt from user_comment_topic ct where ct.topic_id=#{topicId,jdbcType=INTEGER} UNION " +
            "select count(cr.comment_id) as cnt from user_comment_reply cr where cr.reply_id in (select ct.comment_id from user_comment_topic ct where ct.topic_id=#{topicId,jdbcType=INTEGER})" +
            ") as t")
    int getCommentNum(int topicId);

    /*获取某个用户文章评论数*/
    @Select("SELECT SUM(t.cnt) FROM\n" +
            "\t(SELECT count(ct.comment_id) AS cnt FROM user_comment_topic ct WHERE ct.topic_id IN (\n" +
            "\t\t\t\tSELECT a.article_id FROM article a WHERE a.user_id = #{userId,jdbcType=INTEGER})\n" +
            "\t\tUNION\n" +
            "\tSELECT count(cr.comment_id) AS cnt FROM user_comment_reply cr WHERE cr.reply_id IN (SELECT ct.comment_id FROM\n" +
            "\tuser_comment_topic ct WHERE ct.topic_id IN (SELECT a.article_id FROM article a WHERE a.user_id = #{userId,jdbcType=INTEGER}))) AS t")
    int getCommentNumByUser(int userId);

}
