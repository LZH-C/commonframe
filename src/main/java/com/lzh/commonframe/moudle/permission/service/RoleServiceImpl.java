package com.lzh.commonframe.moudle.permission.service;

import com.lzh.commonframe.moudle.user.domain.Role;
import com.lzh.commonframe.moudle.permission.mapper.RoleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService{

    @Autowired
    RoleMapper roleMapper;

    @Override
    public int addRole(Role role) {
        return roleMapper.addRole(role);
    }

    @Override
    public int delRole(int role_id) {
        return roleMapper.delRole(role_id);
    }

    @Override
    public int updateRole(Role role) {
        return roleMapper.updateRole(role);
    }

    @Override
    public List<Role> findByUserName(String userId) {
        return roleMapper.findByUserName(userId);
    }
}
