package com.lzh.commonframe.moudle.user.service;

import com.lzh.commonframe.common.domain.CommonUser;
import com.lzh.commonframe.common.domain.ResponseDTO;
import com.lzh.commonframe.moudle.blog.domain.smiditorResult;
import com.lzh.commonframe.moudle.user.domain.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface UserService {

    /*添加新用户*/
    int addUser(CommonUser user);

    /*删除用户*/
    int delUser(String userName);

    /*修改用户密码*/
    int updatePassword(User user);

    /*根据用户名查询用户*/
    CommonUser findByName(String username);
    /*
     * 登录用户
     * 包含用户名和密码
     * */
    CommonUser login(UserLoginDTO user);

    /*
    * 注册用户
    * */
    int register(UserAddDTO user);

    /*修改用户资料*/
    ResponseDTO<String> updateUserMsg(UserMsgDTO user);

    /*修改用户头像*/
    smiditorResult logoChange(MultipartFile file)throws IOException;

    /*获取用户主要信息*/
    UserMsgDTO getUserMsg(int userId);

    /*获取用户包含原创数，关注数，点击数，评论数，喜欢数*/
    UserRelationDTO getUserRelation(String userName);

}
