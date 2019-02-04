package com.lzh.commonframe.common.mapper;

import com.lzh.commonframe.common.domain.CommonPermission;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

@Mapper
public interface CommonPermissionMapper {
    @Delete({
        "delete from permission",
        "where permission_id = #{permissionId,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer permissionId);

    @Insert({
        "insert into permission (permission_id, permission_name)",
        "values (#{permissionId,jdbcType=INTEGER}, #{permissionName,jdbcType=VARCHAR})"
    })
    int insert(CommonPermission record);

    @InsertProvider(type=CommonPermissionSqlProvider.class, method="insertSelective")
    int insertSelective(CommonPermission record);

    @Select({
        "select",
        "permission_id, permission_name",
        "from permission",
        "where permission_id = #{permissionId,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="permission_id", property="permissionId", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="permission_name", property="permissionName", jdbcType=JdbcType.VARCHAR)
    })
    CommonPermission selectByPrimaryKey(Integer permissionId);

    @UpdateProvider(type=CommonPermissionSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(CommonPermission record);

    @Update({
        "update permission",
        "set permission_name = #{permissionName,jdbcType=VARCHAR}",
        "where permission_id = #{permissionId,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(CommonPermission record);
}