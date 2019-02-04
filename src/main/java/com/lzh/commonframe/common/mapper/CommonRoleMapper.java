package com.lzh.commonframe.common.mapper;

import com.lzh.commonframe.common.domain.CommonRole;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

@Mapper
public interface CommonRoleMapper {
    @Delete({
        "delete from role",
        "where role_id = #{roleId,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer roleId);

    @Insert({
        "insert into role (role_id, role_name)",
        "values (#{roleId,jdbcType=INTEGER}, #{roleName,jdbcType=VARCHAR})"
    })
    int insert(CommonRole record);

    @InsertProvider(type=CommonRoleSqlProvider.class, method="insertSelective")
    int insertSelective(CommonRole record);

    @Select({
        "select",
        "role_id, role_name",
        "from role",
        "where role_id = #{roleId,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="role_id", property="roleId", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="role_name", property="roleName", jdbcType=JdbcType.VARCHAR)
    })
    CommonRole selectByPrimaryKey(Integer roleId);

    @UpdateProvider(type=CommonRoleSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(CommonRole record);

    @Update({
        "update role",
        "set role_name = #{roleName,jdbcType=VARCHAR}",
        "where role_id = #{roleId,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(CommonRole record);
}