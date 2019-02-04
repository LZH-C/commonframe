package com.lzh.commonframe.config.shiro;

import com.lzh.commonframe.common.domain.CommonUser;
import com.lzh.commonframe.common.mapper.CommonUserMapper;
import com.lzh.commonframe.moudle.user.domain.User;
import com.lzh.commonframe.moudle.user.domain.*;
import com.lzh.commonframe.moudle.permission.service.PermissionService;
import com.lzh.commonframe.moudle.permission.service.RoleService;
import com.lzh.commonframe.moudle.user.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.SimplePrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.List;

//实现AuthorizingRealm接口用户用户认证
public class MyShiroRealm extends AuthorizingRealm {

    @Autowired
    private UserService userService;
    @Autowired
    private RoleService roleService;
    @Autowired
    private PermissionService permissionService;
    @Autowired
    private CommonUserMapper CommonUserMapper;

    //角色权限和对应权限添加
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        //获取登录用户名
        User nuser= (User) principalCollection.getPrimaryPrincipal();
        //查询用户
        //User user = userService.findByName(nuser.getUserName());
        List<Role> roles = roleService.findByUserName(nuser.getUserName());
        //添加角色和权限
        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
        for (Role role:roles) {
            //添加角色
            simpleAuthorizationInfo.addRole(role.getRoleName());
            for (Permission permission:permissionService.findByRoleName(role.getRoleId())) {
                //添加权限
                simpleAuthorizationInfo.addStringPermission(permission.getPermissionName());
            }
        }
        return simpleAuthorizationInfo;
    }

    //用户认证
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        //加这一步的目的是在Post请求的时候会先进认证，然后在到请求
        if (authenticationToken.getPrincipal() == null) {
            return null;
        }
        //获取用户信息
        String name = authenticationToken.getPrincipal().toString();
        String password =new String((char[]) authenticationToken.getCredentials());
        UserLoginDTO user=new UserLoginDTO();
        user.setUserName(name);
        user.setPassword(password);
        CommonUser nuser = userService.login(user);
        if (nuser == null) {
            throw new AccountException("帐号或密码不正确！");
        }
        else if(nuser.getUserLock()==(byte)1){
            throw new DisabledAccountException("帐号已经被锁定！");
        }else if(nuser.getUserFreeze()==(byte)1){
            throw new DisabledAccountException("帐号已经被冻结！");
        }else {
            //更新登录时间 last login time
            nuser.setUserLastLoginIp(((UsernamePasswordToken) authenticationToken).getHost());
            nuser.setUserLastLoginTime(new Date());
            CommonUserMapper.updateByPrimaryKeySelective(nuser);
            SecurityUtils.getSubject().getSession().setAttribute("userId",nuser.getUserId());
            //这里验证authenticationToken和simpleAuthenticationInfo的信息
            SimpleAuthenticationInfo simpleAuthenticationInfo = new SimpleAuthenticationInfo(user, nuser.getPassword().toString(), getName());
            return simpleAuthenticationInfo;
        }
    }

    /**
     * 清空当前用户权限信息
     */
    public void clearCachedAuthorizationInfo() {
        PrincipalCollection principalCollection = SecurityUtils.getSubject().getPrincipals();
        SimplePrincipalCollection principals = new SimplePrincipalCollection(
                principalCollection, getName());
        super.clearCachedAuthorizationInfo(principals);
    }
    /**
     * 指定principalCollection 清除
     */
    public void clearCachedAuthorizationInfo(PrincipalCollection principalCollection) {
        SimplePrincipalCollection principals = new SimplePrincipalCollection(
                principalCollection, getName());
        super.clearCachedAuthorizationInfo(principals);
    }

}