package com.lzh.commonframe.moudle.user.domain;

import lombok.Data;


public class UserSignDTO {

    //用户名
    private String userName;

    //密码
    private String passWord;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }
}
