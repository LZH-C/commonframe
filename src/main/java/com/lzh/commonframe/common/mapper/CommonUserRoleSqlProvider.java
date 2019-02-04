package com.lzh.commonframe.common.mapper;

import static org.apache.ibatis.jdbc.SqlBuilder.BEGIN;
import static org.apache.ibatis.jdbc.SqlBuilder.INSERT_INTO;
import static org.apache.ibatis.jdbc.SqlBuilder.SQL;
import static org.apache.ibatis.jdbc.SqlBuilder.VALUES;

import com.lzh.commonframe.common.domain.CommonUserRoleKey;

public class CommonUserRoleSqlProvider {

    public String insertSelective(CommonUserRoleKey record) {
        BEGIN();
        INSERT_INTO("user_role");
        
        if (record.getUserId() != null) {
            VALUES("user_id", "#{userId,jdbcType=INTEGER}");
        }
        
        if (record.getRoleId() != null) {
            VALUES("role_id", "#{roleId,jdbcType=INTEGER}");
        }
        
        return SQL();
    }
}