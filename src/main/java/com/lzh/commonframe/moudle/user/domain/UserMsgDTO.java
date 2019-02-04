package com.lzh.commonframe.moudle.user.domain;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class UserMsgDTO implements Serializable{
    private static final long serialVersionUID = 1L;

    private int userId;

    private String userName;

    private String password;

    private String email;

    private Integer userPhone;

    private String userRealName;

    private String userTrade;

    private String userPosition;

    private String userArea;

    private Date userBirth;

    private String userGender;

    private String userImageUrl;

    private String userDescription;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(Integer userPhone) {
        this.userPhone = userPhone;
    }

    public String getUserRealName() {
        return userRealName;
    }

    public void setUserRealName(String userRealName) {
        this.userRealName = userRealName;
    }

    public String getUserTrade() {
        return userTrade;
    }

    public void setUserTrade(String userTrade) {
        this.userTrade = userTrade;
    }

    public String getUserPosition() {
        return userPosition;
    }

    public void setUserPosition(String userPosition) {
        this.userPosition = userPosition;
    }

    public String getUserArea() {
        return userArea;
    }

    public void setUserArea(String userArea) {
        this.userArea = userArea;
    }

    public Date getUserBirth() {
        return userBirth;
    }

    public void setUserBirth(Date userBirth) {
        this.userBirth = userBirth;
    }

    public String getUserGender() {
        return userGender;
    }

    public void setUserGender(String userGender) {
        this.userGender = userGender;
    }

    public String getUserImageUrl() {
        return userImageUrl;
    }

    public void setUserImageUrl(String userImageUrl) {
        this.userImageUrl = userImageUrl;
    }

    public String getUserDescription() {
        return userDescription;
    }

    public void setUserDescription(String userDescription) {
        this.userDescription = userDescription;
    }
}