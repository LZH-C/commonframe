package com.lzh.commonframe.common.mapper;

import com.lzh.commonframe.common.domain.CommonCommentTopic;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

@Mapper
public interface CommonCommentTopicMapper {
    @Delete({
        "delete from user_comment_topic",
        "where comment_id = #{commentId,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer commentId);

    @Insert({
        "insert into user_comment_topic (comment_id, topic_id, ",
        "content, from_uid, ",
        "commit_time, commit_ip)",
        "values (#{commentId,jdbcType=INTEGER}, #{topicId,jdbcType=INTEGER}, ",
        "#{content,jdbcType=VARCHAR}, #{fromUid,jdbcType=INTEGER}, ",
        "#{commitTime,jdbcType=TIMESTAMP}, #{commitIp,jdbcType=VARCHAR})"
    })
    int insert(CommonCommentTopic record);

    @InsertProvider(type=CommonCommentTopicSqlProvider.class, method="insertSelective")
    int insertSelective(CommonCommentTopic record);

    @Select({
        "select",
        "comment_id, topic_id, content, from_uid, commit_time, commit_ip",
        "from user_comment_topic",
        "where comment_id = #{commentId,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="comment_id", property="commentId", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="topic_id", property="topicId", jdbcType=JdbcType.INTEGER),
        @Result(column="content", property="content", jdbcType=JdbcType.VARCHAR),
        @Result(column="from_uid", property="fromUid", jdbcType=JdbcType.INTEGER),
        @Result(column="commit_time", property="commitTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="commit_ip", property="commitIp", jdbcType=JdbcType.VARCHAR)
    })
    CommonCommentTopic selectByPrimaryKey(Integer commentId);

    @UpdateProvider(type=CommonCommentTopicSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(CommonCommentTopic record);

    @Update({
        "update user_comment_topic",
        "set topic_id = #{topicId,jdbcType=INTEGER},",
          "content = #{content,jdbcType=VARCHAR},",
          "from_uid = #{fromUid,jdbcType=INTEGER},",
          "commit_time = #{commitTime,jdbcType=TIMESTAMP},",
          "commit_ip = #{commitIp,jdbcType=VARCHAR}",
        "where comment_id = #{commentId,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(CommonCommentTopic record);
}