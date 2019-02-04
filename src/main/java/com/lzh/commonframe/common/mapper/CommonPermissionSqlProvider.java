package com.lzh.commonframe.common.mapper;

import static org.apache.ibatis.jdbc.SqlBuilder.BEGIN;
import static org.apache.ibatis.jdbc.SqlBuilder.INSERT_INTO;
import static org.apache.ibatis.jdbc.SqlBuilder.SET;
import static org.apache.ibatis.jdbc.SqlBuilder.SQL;
import static org.apache.ibatis.jdbc.SqlBuilder.UPDATE;
import static org.apache.ibatis.jdbc.SqlBuilder.VALUES;
import static org.apache.ibatis.jdbc.SqlBuilder.WHERE;

import com.lzh.commonframe.common.domain.CommonPermission;

public class CommonPermissionSqlProvider {

    public String insertSelective(CommonPermission record) {
        BEGIN();
        INSERT_INTO("permission");
        
        if (record.getPermissionId() != null) {
            VALUES("permission_id", "#{permissionId,jdbcType=INTEGER}");
        }
        
        if (record.getPermissionName() != null) {
            VALUES("permission_name", "#{permissionName,jdbcType=VARCHAR}");
        }
        
        return SQL();
    }

    public String updateByPrimaryKeySelective(CommonPermission record) {
        BEGIN();
        UPDATE("permission");
        
        if (record.getPermissionName() != null) {
            SET("permission_name = #{permissionName,jdbcType=VARCHAR}");
        }
        
        WHERE("permission_id = #{permissionId,jdbcType=INTEGER}");
        
        return SQL();
    }
}