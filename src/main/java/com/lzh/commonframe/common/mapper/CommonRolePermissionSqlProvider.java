package com.lzh.commonframe.common.mapper;

import static org.apache.ibatis.jdbc.SqlBuilder.BEGIN;
import static org.apache.ibatis.jdbc.SqlBuilder.INSERT_INTO;
import static org.apache.ibatis.jdbc.SqlBuilder.SQL;
import static org.apache.ibatis.jdbc.SqlBuilder.VALUES;

import com.lzh.commonframe.common.domain.CommonRolePermissionKey;

public class CommonRolePermissionSqlProvider {

    public String insertSelective(CommonRolePermissionKey record) {
        BEGIN();
        INSERT_INTO("role_permission");
        
        if (record.getRoleId() != null) {
            VALUES("role_id", "#{roleId,jdbcType=INTEGER}");
        }
        
        if (record.getPermissionId() != null) {
            VALUES("permission_id", "#{permissionId,jdbcType=INTEGER}");
        }
        
        return SQL();
    }
}