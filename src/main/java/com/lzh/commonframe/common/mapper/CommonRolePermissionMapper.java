package com.lzh.commonframe.common.mapper;

import com.lzh.commonframe.common.domain.CommonRolePermissionKey;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CommonRolePermissionMapper {
    @Delete({
        "delete from role_permission",
        "where role_id = #{roleId,jdbcType=INTEGER}",
          "and permission_id = #{permissionId,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(CommonRolePermissionKey key);

    @Insert({
        "insert into role_permission (role_id, permission_id)",
        "values (#{roleId,jdbcType=INTEGER}, #{permissionId,jdbcType=INTEGER})"
    })
    int insert(CommonRolePermissionKey record);

    @InsertProvider(type=CommonRolePermissionSqlProvider.class, method="insertSelective")
    int insertSelective(CommonRolePermissionKey record);
}