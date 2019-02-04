package com.lzh.commonframe.common.mapper;

import static org.apache.ibatis.jdbc.SqlBuilder.BEGIN;
import static org.apache.ibatis.jdbc.SqlBuilder.INSERT_INTO;
import static org.apache.ibatis.jdbc.SqlBuilder.SET;
import static org.apache.ibatis.jdbc.SqlBuilder.SQL;
import static org.apache.ibatis.jdbc.SqlBuilder.UPDATE;
import static org.apache.ibatis.jdbc.SqlBuilder.VALUES;
import static org.apache.ibatis.jdbc.SqlBuilder.WHERE;

import com.lzh.commonframe.common.domain.CommonCommentReply;

public class CommonCommentReplySqlProvider {

    public String insertSelective(CommonCommentReply record) {
        BEGIN();
        INSERT_INTO("user_comment_reply");
        
        if (record.getCommentId() != null) {
            VALUES("comment_id", "#{commentId,jdbcType=INTEGER}");
        }
        
        if (record.getReplyId() != null) {
            VALUES("reply_id", "#{replyId,jdbcType=INTEGER}");
        }
        
        if (record.getReplyUserId() != null) {
            VALUES("reply_user_id", "#{replyUserId,jdbcType=INTEGER}");
        }
        
        if (record.getCommitContent() != null) {
            VALUES("commit_content", "#{commitContent,jdbcType=VARCHAR}");
        }
        
        if (record.getCommitUserId() != null) {
            VALUES("commit_user_id", "#{commitUserId,jdbcType=INTEGER}");
        }
        
        if (record.getCommitTime() != null) {
            VALUES("commit_time", "#{commitTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getCommitIp() != null) {
            VALUES("commit_ip", "#{commitIp,jdbcType=VARCHAR}");
        }
        
        return SQL();
    }

    public String updateByPrimaryKeySelective(CommonCommentReply record) {
        BEGIN();
        UPDATE("user_comment_reply");
        
        if (record.getReplyId() != null) {
            SET("reply_id = #{replyId,jdbcType=INTEGER}");
        }
        
        if (record.getReplyUserId() != null) {
            SET("reply_user_id = #{replyUserId,jdbcType=INTEGER}");
        }
        
        if (record.getCommitContent() != null) {
            SET("commit_content = #{commitContent,jdbcType=VARCHAR}");
        }
        
        if (record.getCommitUserId() != null) {
            SET("commit_user_id = #{commitUserId,jdbcType=INTEGER}");
        }
        
        if (record.getCommitTime() != null) {
            SET("commit_time = #{commitTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getCommitIp() != null) {
            SET("commit_ip = #{commitIp,jdbcType=VARCHAR}");
        }
        
        WHERE("comment_id = #{commentId,jdbcType=INTEGER}");
        
        return SQL();
    }
}