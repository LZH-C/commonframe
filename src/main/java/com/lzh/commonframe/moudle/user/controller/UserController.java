package com.lzh.commonframe.moudle.user.controller;

import com.lzh.commonframe.common.domain.ResponseDTO;
import com.lzh.commonframe.common.util.Md5Utils;
import com.lzh.commonframe.config.shiro.manager.TokenManager;
import com.lzh.commonframe.moudle.user.constant.UserResponseCodeConst;
import com.lzh.commonframe.moudle.user.domain.UserMsgDTO;
import com.lzh.commonframe.moudle.user.domain.UserAddDTO;
import com.lzh.commonframe.moudle.user.domain.UserLoginDTO;
import com.lzh.commonframe.moudle.user.domain.UserRelationDTO;
import com.lzh.commonframe.moudle.user.service.UserService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.io.IOException;
import java.util.Date;

@Api(tags = "用户")
@Controller
@ResponseBody
public class UserController {

    @Autowired
    private UserService userService;

    /*注册用户*/
    @PostMapping("/user/register")
    public ResponseDTO register(UserAddDTO entity , HttpServletRequest httpServletRequest){
        String salt=entity.getPassword().substring(1,3)+entity.getEmail().substring(1,3)+(new Date()).toString().substring(0,3);
        salt= Md5Utils.hash(salt);
        entity.setSalt(salt);
        entity.setPassword(Md5Utils.encryptPassword(entity.getPassword(),salt));
        entity.setUserRegisterTime(new Date());
        entity.setUserImageUrl("http://localhost:8080/static/img/logo.jpg");
        entity.setUserRegisterIp(httpServletRequest.getRemoteAddr());
        entity.setUserFreeze((byte)0);
        entity.setUserLock((byte)0);
        try {
            userService.register(entity);
            return ResponseDTO.succMsg("注册成功!");
        }catch (Exception e){
            return ResponseDTO.succMsg("注册失败!");
        }

    }

    /*登录用户*/
    @PostMapping("/user/login")
    public ResponseDTO login(@Valid HttpServletRequest request, UserLoginDTO entity){
        //进行验证，这里可以捕获异常，然后返回对应信息
        try {
            entity.setPassword(Md5Utils.encryptPassword(entity.getPassword(),userService.findByName(entity.getUserName()).getSalt()));
            TokenManager.login(entity,true,request.getRemoteAddr());
            System.out.println("登录成功");
            return new ResponseDTO("登录成功！",TokenManager.getToken());
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("登录失败");
            return ResponseDTO.wrap(UserResponseCodeConst.PASSWORD_ERROR);
        }
    }

    //登出
    @GetMapping("/user/logout")
    public String logout(){
        try {
            TokenManager.logout();
            System.out.println("登出成功！");
            return "logout";
        }catch (Exception e){
            System.out.println("登出失败！");
            return "error";
        }
    }

    /*验证是否处于登录状态*/
    @GetMapping("/user/isAuthenticated")
    public boolean isAuthenticated(String sessionID, HttpServletRequest request, HttpServletResponse response){
        return TokenManager.isLogin();
    }

    /*修改用户资料*/
    @PostMapping("/user/msg/update")
    public ResponseDTO updateUserMsg(UserMsgDTO user){
        return userService.updateUserMsg(user);
    }

    /*修改用户头像*/
    @PostMapping("/user/logo/change")
    public ResponseDTO logoChange(MultipartFile file)throws IOException {
        userService.logoChange(file);
        return ResponseDTO.succMsg("上传成功！");
    }

    /*获取用户主要信息*/
    @GetMapping("/user/msg")
    public ResponseDTO getUserMsg(HttpServletRequest req){
        ResponseDTO dto = new ResponseDTO("获取成功！",userService.getUserMsg(TokenManager.getUserId()));
        req.setAttribute("userMsg",dto);
        return dto;
    }

    /*获取用户包含原创数，关注数，点击数，评论数，喜欢数*/
    @GetMapping("/user/getUserRelation/{userName}")
    public ResponseDTO getUserRelation(@PathVariable  String userName){
        return new ResponseDTO("获取成功！",userService.getUserRelation(userName));
    }

}
