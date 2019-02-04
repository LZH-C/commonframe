package com.lzh.commonframe.moudle.permission.mapper;

import com.lzh.commonframe.moudle.user.domain.Permission;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface PermissionMapper {

    /*添加新权限*/
    @Insert("insert into Permission(permission_name) values(#{permissionName})")
    int addPermission(Permission permission);

    /*删除权限*/
    @Delete("delete Permission where permission_id=#{permission_id}")
    int delPermission(String permission_id);

    /*修改权限*/
    @Update("update Permission set permission_name=#{permissionName} where permission_id=#{permissionId}")
    int updatePermission(Permission Permission);

    /*根据角色ID查询拥有的权限*/
    @Select("select * from Role_Permission where role_id=#{roleId}")
    List<Permission> findByRoleName(int roleId);
}
