package com.lzh.commonframe.moudle.user.domain;

import java.io.Serializable;
import java.util.Date;

public class User implements Serializable {
    private static final long serialVersionUID = 1L;
    //0:禁止登录
    public static final Long _0 = new Long(0);
    //1:有效
    public static final Long _1 = new Long(1);

    private Integer userId;

    private String userName;

    private String password;

    private String email;

    private Date createTime;

    private Date lastLoginTime;

    private String salt;

    private Long status;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getLastLoginTime() {
        return lastLoginTime;
    }

    public void setLastLoginTime(Date lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt == null ? null : salt.trim();
    }

    public Long getStatus() {
        return status;
    }

    public void setStatus(Long status) {
        this.status = status;
    }

    public User() {}
    public User(User user) {
        this.userId = user.getUserId();
        this.userName = user.getUserName();
        this.email = user.getEmail();
        this.password = user.getPassword();
        this.createTime = user.getCreateTime();
        this.lastLoginTime = user.getLastLoginTime();
        this.salt=user.getSalt();
    }

}