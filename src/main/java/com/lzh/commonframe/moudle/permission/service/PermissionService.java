package com.lzh.commonframe.moudle.permission.service;

import com.lzh.commonframe.moudle.user.domain.Permission;

import java.util.List;

public interface PermissionService {

    /*添加新权限*/
    int addPermission(Permission permission);

    /*删除权限*/
    int delPermission(String permission_id);

    /*修改权限*/
    int updatePermission(Permission permission);

    /*根据角色ID查询拥有的权限*/
    List<Permission> findByRoleName(int roleId);

}
