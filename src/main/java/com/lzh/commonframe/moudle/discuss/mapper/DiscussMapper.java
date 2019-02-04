package com.lzh.commonframe.moudle.discuss.mapper;

import com.lzh.commonframe.common.domain.CommonCommentReply;
import com.lzh.commonframe.common.domain.CommonCommentTopic;
import com.lzh.commonframe.moudle.discuss.domain.CommentDTO;
import com.lzh.commonframe.moudle.discuss.domain.CommentReplies;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

import java.util.List;

@Mapper
public interface DiscussMapper {

    /*用户发布评论*/
    //int addCommentToTopic(Commonuser comment);

    /*用户回复评论*/
    @Insert({
            "insert into user_comment_reply (reply_id, ",
            "reply_user_id, commit_content, ",
            "commit_user_id, commit_time, ",
            "commit_ip)",
            "values (#{replyId,jdbcType=INTEGER}, ",
            "(select user_id from user where user_name=#{beReplyName,jdbcType=VARCHAR}), #{commitContent,jdbcType=VARCHAR}, ",
            "#{commitUserId,jdbcType=INTEGER}, #{commitTime,jdbcType=TIMESTAMP}, ",
            "#{commitIp,jdbcType=VARCHAR})"
    })
    int addCommentToUser(CommentReplies commentReply);


    /*加载主题评论*/
    @Select({
            "select",
            "u.user_name,u.user_image_url, t.comment_id, t.topic_id, t.content, t.from_uid, t.commit_time, t.commit_ip",
            "from user_comment_topic t,user u",
            "where t.topic_id = #{topicId,jdbcType=INTEGER} and t.from_uid=u.user_id"
    })
    @Results({
            @Result(column="comment_id", property="commentId", jdbcType= JdbcType.INTEGER, id=true),
            @Result(column="topic_id", property="topicId", jdbcType=JdbcType.INTEGER),
            @Result(column="content", property="content", jdbcType=JdbcType.VARCHAR),
            @Result(column="from_uid", property="fromUid", jdbcType=JdbcType.INTEGER),
            @Result(column="commit_time", property="commitTime", jdbcType=JdbcType.TIMESTAMP),
            @Result(column="commit_ip", property="commitIp", jdbcType=JdbcType.VARCHAR),
            @Result(column="user_name", property="userName", jdbcType=JdbcType.VARCHAR),
            @Result(column="user_image_url", property="userImageUrl", jdbcType=JdbcType.VARCHAR)
    })
    List<CommentDTO> loadTopicComment(int topicId);

    @Select("SELECT r.comment_id,	r.reply_id,r.commit_content,	r.commit_user_id,	r.commit_time,	r.commit_ip,	u.user_name,	u.user_image_url,t.user_id reply_user_id,t.user_name reply_user_name"+
            " FROM	user_comment_reply r,	user u,	user t WHERE	r.reply_id =#{commentId,jdbcType=INTEGER} AND r.commit_user_id = u.user_id AND r.reply_user_id = t.user_id")
    @Results({
            @Result(column="comment_id", property="commentId", jdbcType=JdbcType.INTEGER, id=true),
            @Result(column="reply_id", property="replyId", jdbcType=JdbcType.INTEGER),
            @Result(column="commit_content", property="commitContent", jdbcType=JdbcType.VARCHAR),
            @Result(column="commit_user_id", property="commitUserId", jdbcType=JdbcType.INTEGER),
            @Result(column="commit_time", property="commitTime", jdbcType=JdbcType.TIMESTAMP),
            @Result(column="commit_ip", property="commitIp", jdbcType=JdbcType.VARCHAR),
            @Result(column="user_name", property="replyName", jdbcType=JdbcType.VARCHAR),
            @Result(column="user_image_url", property="userImageUrl", jdbcType=JdbcType.VARCHAR),
            @Result(column="reply_user_name", property="beReplyName", jdbcType=JdbcType.VARCHAR),
            @Result(column="reply_user_id", property="replyUserId", jdbcType=JdbcType.INTEGER)
    })
    List<CommentReplies> loadReplyComments(int commentId);

    /*修改评论*/
    //int updateComment();

    /*删除评论*/
    //int delComment();



}
