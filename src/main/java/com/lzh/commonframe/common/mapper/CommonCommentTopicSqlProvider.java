package com.lzh.commonframe.common.mapper;

import static org.apache.ibatis.jdbc.SqlBuilder.BEGIN;
import static org.apache.ibatis.jdbc.SqlBuilder.INSERT_INTO;
import static org.apache.ibatis.jdbc.SqlBuilder.SET;
import static org.apache.ibatis.jdbc.SqlBuilder.SQL;
import static org.apache.ibatis.jdbc.SqlBuilder.UPDATE;
import static org.apache.ibatis.jdbc.SqlBuilder.VALUES;
import static org.apache.ibatis.jdbc.SqlBuilder.WHERE;

import com.lzh.commonframe.common.domain.CommonCommentTopic;

public class CommonCommentTopicSqlProvider {

    public String insertSelective(CommonCommentTopic record) {
        BEGIN();
        INSERT_INTO("user_comment_topic");
        
        if (record.getCommentId() != null) {
            VALUES("comment_id", "#{commentId,jdbcType=INTEGER}");
        }
        
        if (record.getTopicId() != null) {
            VALUES("topic_id", "#{topicId,jdbcType=INTEGER}");
        }
        
        if (record.getContent() != null) {
            VALUES("content", "#{content,jdbcType=VARCHAR}");
        }
        
        if (record.getFromUid() != null) {
            VALUES("from_uid", "#{fromUid,jdbcType=INTEGER}");
        }
        
        if (record.getCommitTime() != null) {
            VALUES("commit_time", "#{commitTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getCommitIp() != null) {
            VALUES("commit_ip", "#{commitIp,jdbcType=VARCHAR}");
        }
        
        return SQL();
    }

    public String updateByPrimaryKeySelective(CommonCommentTopic record) {
        BEGIN();
        UPDATE("user_comment_topic");
        
        if (record.getTopicId() != null) {
            SET("topic_id = #{topicId,jdbcType=INTEGER}");
        }
        
        if (record.getContent() != null) {
            SET("content = #{content,jdbcType=VARCHAR}");
        }
        
        if (record.getFromUid() != null) {
            SET("from_uid = #{fromUid,jdbcType=INTEGER}");
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