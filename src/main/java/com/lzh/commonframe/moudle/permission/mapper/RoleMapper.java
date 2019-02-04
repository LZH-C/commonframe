package com.lzh.commonframe.moudle.permission.mapper;

import com.lzh.commonframe.moudle.user.domain.Role;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface RoleMapper {

    /*添加新角色*/
    @Insert("insert into Role(role_name) values(#{roleName})")
    int addRole(Role role);

    /*删除角色*/
    @Delete("delete Role where role_name=#{roleName}")
    int delRole(int role_id);

    /*修改角色*/
    @Update("update Role set role_name=#{roleName} where role_id=#{roleId}")
    int updateRole(Role role);

    /*根据用户id查询对应的角色*/
    @Select("select * from Role where role_id in (select role_id from User_Role where user_id = #{userId})")
    List<Role> findByUserName(String userId);
}
