package com.lzh.commonframe.common.mapper;

import static org.apache.ibatis.jdbc.SqlBuilder.BEGIN;
import static org.apache.ibatis.jdbc.SqlBuilder.INSERT_INTO;
import static org.apache.ibatis.jdbc.SqlBuilder.SET;
import static org.apache.ibatis.jdbc.SqlBuilder.SQL;
import static org.apache.ibatis.jdbc.SqlBuilder.UPDATE;
import static org.apache.ibatis.jdbc.SqlBuilder.VALUES;
import static org.apache.ibatis.jdbc.SqlBuilder.WHERE;

import com.lzh.commonframe.common.domain.CommonRole;

public class CommonRoleSqlProvider {

    public String insertSelective(CommonRole record) {
        BEGIN();
        INSERT_INTO("role");
        
        if (record.getRoleId() != null) {
            VALUES("role_id", "#{roleId,jdbcType=INTEGER}");
        }
        
        if (record.getRoleName() != null) {
            VALUES("role_name", "#{roleName,jdbcType=VARCHAR}");
        }
        
        return SQL();
    }

    public String updateByPrimaryKeySelective(CommonRole record) {
        BEGIN();
        UPDATE("role");
        
        if (record.getRoleName() != null) {
            SET("role_name = #{roleName,jdbcType=VARCHAR}");
        }
        
        WHERE("role_id = #{roleId,jdbcType=INTEGER}");
        
        return SQL();
    }
}