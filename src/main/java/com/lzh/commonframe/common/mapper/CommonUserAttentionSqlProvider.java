package com.lzh.commonframe.common.mapper;

import static org.apache.ibatis.jdbc.SqlBuilder.BEGIN;
import static org.apache.ibatis.jdbc.SqlBuilder.INSERT_INTO;
import static org.apache.ibatis.jdbc.SqlBuilder.SET;
import static org.apache.ibatis.jdbc.SqlBuilder.SQL;
import static org.apache.ibatis.jdbc.SqlBuilder.UPDATE;
import static org.apache.ibatis.jdbc.SqlBuilder.VALUES;
import static org.apache.ibatis.jdbc.SqlBuilder.WHERE;

import com.lzh.commonframe.common.domain.CommonUserAttention;

public class CommonUserAttentionSqlProvider {

    public String insertSelective(CommonUserAttention record) {
        BEGIN();
        INSERT_INTO("user_attention");
        
        if (record.getaId() != null) {
            VALUES("a_id", "#{aId,jdbcType=SMALLINT}");
        }
        
        if (record.getUserId() != null) {
            VALUES("user_id", "#{userId,jdbcType=INTEGER}");
        }
        
        if (record.getAttentionId() != null) {
            VALUES("attention_id", "#{attentionId,jdbcType=INTEGER}");
        }
        
        return SQL();
    }

    public String updateByPrimaryKeySelective(CommonUserAttention record) {
        BEGIN();
        UPDATE("user_attention");
        
        if (record.getUserId() != null) {
            SET("user_id = #{userId,jdbcType=INTEGER}");
        }
        
        if (record.getAttentionId() != null) {
            SET("attention_id = #{attentionId,jdbcType=INTEGER}");
        }
        
        WHERE("a_id = #{aId,jdbcType=SMALLINT}");
        
        return SQL();
    }
}