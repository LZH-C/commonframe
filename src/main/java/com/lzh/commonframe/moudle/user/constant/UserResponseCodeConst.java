package com.lzh.commonframe.moudle.user.constant;


import com.lzh.commonframe.constant.ResponseCodeConst;

public class UserResponseCodeConst extends ResponseCodeConst {

    public static final UserResponseCodeConst USER_OFF_LINE = new UserResponseCodeConst(1001, "用户没有登录！");
    public static final UserResponseCodeConst MOBILE_PHONE_EXIST = new UserResponseCodeConst(1002, "手机号已经存在！");
    public static final UserResponseCodeConst NICK_NAME_EXIST = new UserResponseCodeConst(1003, "昵称已经存在！");
    public static final UserResponseCodeConst PASSWORD_ERROR = new UserResponseCodeConst(1004, "用户名或密码错误！");
    public static final UserResponseCodeConst EMAIL_EXIST = new UserResponseCodeConst(1005, "邮箱已经存在！");
    public static final UserResponseCodeConst EMAIL_NOT_EXIST = new UserResponseCodeConst(1006, "邮箱不存在！");
    public static final UserResponseCodeConst RESET_PWD_TIMEOUT = new UserResponseCodeConst(1007, "重置密码超时！");

    public UserResponseCodeConst(int code, String msg) {
        super(code, msg);
    }

}
