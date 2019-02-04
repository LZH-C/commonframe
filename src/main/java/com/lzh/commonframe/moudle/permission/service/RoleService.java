package com.lzh.commonframe.moudle.permission.service;

import com.lzh.commonframe.moudle.user.domain.Role;

import java.util.List;


public interface RoleService {

    /*添加新角色*/
    int addRole(Role role);

    /*删除角色*/
    int delRole(int role_id);

    /*修改角色*/
    int updateRole(Role role);

    /*根据用户id查询对应的角色*/
    List<Role> findByUserName(String userId);

}
