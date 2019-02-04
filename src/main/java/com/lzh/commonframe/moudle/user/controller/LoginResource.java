package com.lzh.commonframe.moudle.user.controller;

import com.lzh.commonframe.common.domain.CommonUser;
import com.lzh.commonframe.common.domain.ResponseDTO;
import com.lzh.commonframe.common.util.Md5Utils;
import com.lzh.commonframe.config.shiro.manager.TokenManager;
import com.lzh.commonframe.moudle.user.domain.Role;
import com.lzh.commonframe.moudle.user.domain.User;
import com.lzh.commonframe.moudle.permission.service.PermissionService;
import com.lzh.commonframe.moudle.permission.service.RoleService;
import com.lzh.commonframe.moudle.user.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.Date;


@Api(tags = "登录权限")
@Controller
public class LoginResource {

    @Autowired
    private UserService userService;
    @Autowired
    private RoleService roleService;
    @Autowired
    private PermissionService permissionService;

    //数据初始化
    @RequestMapping("/addUser")
    @ApiOperation(value = "数据初始化", notes = "数据初始化")
    public String addUser(@RequestBody CommonUser user){
        int count=userService.addUser(user);
        if(count!=1){
            return "addUser is not ok! \n";
        }
        return "addUser is ok! \n" + user;
    }

    //角色初始化
    @RequestMapping("/addRole")
    @ApiOperation(value = "角色初始化", notes = "角色初始化")
    public String addRole(@RequestBody Role role){
        int count= roleService.addRole(role);
        if(count!=1){
            return "addRole is not ok! \n";
        }
        return "addRole is ok! \n" + role;
    }

    //注解的使用
    @RequiresRoles("admin")
    @RequiresPermissions("create")
    @RequestMapping(value = "/create")
    public String create(){
        return "Create success!";
    }
}