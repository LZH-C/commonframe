package com.lzh.commonframe.moudle.permission.service;

import com.lzh.commonframe.moudle.user.domain.Permission;
import com.lzh.commonframe.moudle.permission.mapper.PermissionMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PermissionServiceImpl implements PermissionService{

    @Autowired
    PermissionMapper permissionMapper;

    @Override
    public int addPermission(Permission permission) {
        return permissionMapper.addPermission(permission);
    }

    @Override
    public int delPermission(String permission_id) {
        return permissionMapper.delPermission(permission_id);
    }

    @Override
    public int updatePermission(Permission permission) {
        return permissionMapper.updatePermission(permission);
    }

    @Override
    public List<Permission> findByRoleName(int roleId) {
        return permissionMapper.findByRoleName(roleId);
    }
}
