package com.lzh.commonframe.common.mapper;

import com.lzh.commonframe.common.domain.CommonCommentReply;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

@Mapper
public interface CommonCommentReplyMapper {
    @Delete({
        "delete from user_comment_reply",
        "where comment_id = #{commentId,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer commentId);

    @Insert({
        "insert into user_comment_reply (comment_id, reply_id, ",
        "reply_user_id, commit_content, ",
        "commit_user_id, commit_time, ",
        "commit_ip)",
        "values (#{commentId,jdbcType=INTEGER}, #{replyId,jdbcType=INTEGER}, ",
        "#{replyUserId,jdbcType=INTEGER}, #{commitContent,jdbcType=VARCHAR}, ",
        "#{commitUserId,jdbcType=INTEGER}, #{commitTime,jdbcType=TIMESTAMP}, ",
        "#{commitIp,jdbcType=VARCHAR})"
    })
    int insert(CommonCommentReply record);

    @InsertProvider(type=CommonCommentReplySqlProvider.class, method="insertSelective")
    int insertSelective(CommonCommentReply record);

    @Select({
        "select",
        "comment_id, reply_id, reply_user_id, commit_content, commit_user_id, commit_time, ",
        "commit_ip",
        "from user_comment_reply",
        "where comment_id = #{commentId,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="comment_id", property="commentId", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="reply_id", property="replyId", jdbcType=JdbcType.INTEGER),
        @Result(column="reply_user_id", property="replyUserId", jdbcType=JdbcType.INTEGER),
        @Result(column="commit_content", property="commitContent", jdbcType=JdbcType.VARCHAR),
        @Result(column="commit_user_id", property="commitUserId", jdbcType=JdbcType.INTEGER),
        @Result(column="commit_time", property="commitTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="commit_ip", property="commitIp", jdbcType=JdbcType.VARCHAR)
    })
    CommonCommentReply selectByPrimaryKey(Integer commentId);

    @UpdateProvider(type=CommonCommentReplySqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(CommonCommentReply record);

    @Update({
        "update user_comment_reply",
        "set reply_id = #{replyId,jdbcType=INTEGER},",
          "reply_user_id = #{replyUserId,jdbcType=INTEGER},",
          "commit_content = #{commitContent,jdbcType=VARCHAR},",
          "commit_user_id = #{commitUserId,jdbcType=INTEGER},",
          "commit_time = #{commitTime,jdbcType=TIMESTAMP},",
          "commit_ip = #{commitIp,jdbcType=VARCHAR}",
        "where comment_id = #{commentId,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(CommonCommentReply record);
}