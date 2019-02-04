package com.lzh.commonframe.moudle.user.service;

import com.lzh.commonframe.common.domain.CommonUser;
import com.lzh.commonframe.common.domain.ResponseDTO;
import com.lzh.commonframe.common.mapper.CommonUserMapper;
import com.lzh.commonframe.config.shiro.manager.TokenManager;
import com.lzh.commonframe.moudle.blog.domain.smiditorResult;
import com.lzh.commonframe.moudle.blog.mapper.BlogMapper;
import com.lzh.commonframe.moudle.user.domain.*;
import com.lzh.commonframe.moudle.user.mapper.UserMapper;
import com.lzh.commonframe.util.FTPUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;


@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;
    @Autowired
    CommonUserMapper commonUserMapper;
    @Autowired
    BlogMapper blogMapper;


    @Override
    public int addUser(CommonUser user) {
        return userMapper.addUser(user);
    }

    @Override
    public int delUser(String userName) {
        return userMapper.delUser(userName);
    }

    @Override
    public int updatePassword(User user) {
        return userMapper.updatePassword(user);
    }

    @Override
    public CommonUser findByName(String username) {
        return userMapper.findByName(username);
    }

    @Override
    public CommonUser login(UserLoginDTO user) {
        return userMapper.login(user);
    }

    @Override
    public int register(UserAddDTO user) {
        return userMapper.register(user);
    }

    @Override
    public ResponseDTO<String> updateUserMsg(UserMsgDTO user) {
        try {
            user.setUserId(TokenManager.getUserId());
            if(user.getUserBirth().toString().equals("Thu Jan 01 00:00:00 CST 1970")){
                user.setUserBirth(null);
            }
            if(user.getUserArea().equals("--")){
                user.setUserArea(null);
            }
            userMapper.updateByPrimaryKeySelective(user);
            System.out.println("更新成功!");
            return ResponseDTO.succData("更新成功！");
        }catch (Exception e){
            return ResponseDTO.succData("更新失败！");
        }
    }

    @Override
    public smiditorResult logoChange(MultipartFile file) throws IOException {
        if(file.isEmpty()){
            System.out.println("上传失败");
            return new smiditorResult("null",false,"上传失败");
        }
        if (file!=null) {// 判断上传的文件是否为空
            String type = null;// 文件类型
            String fileName = file.getOriginalFilename();// 文件原名称
            System.out.println("上传的文件原名称:"+fileName);
            // 判断文件类型
            type = fileName.indexOf(".")!=-1?fileName.substring(fileName.lastIndexOf(".")+1, fileName.length()):null;
            if (type!=null) {// 判断文件类型是否为空
                if ("GIF".equals(type.toUpperCase())||"PNG".equals(type.toUpperCase())||"JPG".equals(type.toUpperCase())||"JPEG".equals(type.toUpperCase())) {
                    // 项目在容器中实际发布运行的根路径
                    String realPath = "http://182.61.55.14/imageHead/";
                    // 自定义的文件名称
                    String trueFileName = String.valueOf(System.currentTimeMillis()) + "." + type;
                    // 设置存放图片文件的路径
                    String path=realPath+trueFileName;
                    System.out.println("存放图片文件的路径:"+path);
                    InputStream inputStream = file.getInputStream();
                    boolean flag = FTPUtil.uploadFile("182.61.55.14", 21, "ftpuser", "2282924", "/data/ftp","/imageHead", trueFileName, inputStream);
                    if(flag){
                        System.out.println("上传成功！");
                        //更新url
                        CommonUser user = new CommonUser();
                        user.setUserId(TokenManager.getUserId());
                        user.setUserImageUrl(path);
                        commonUserMapper.updateByPrimaryKeySelective(user);
                        return new smiditorResult(path,true,"文件成功上传到指定目录下");
                    }else{
                        return new smiditorResult("null",false,"上传失败");
                    }
                }else {
                    return new smiditorResult("null",false,"不是我们想要的文件类型,请按要求重新上传");
                }
            }else {
                return new smiditorResult("null",false,"文件类型为空");
            }
        }else {
            return new smiditorResult("null",false,"没有找到相对应的文件");
        }
    }

    @Override
    public UserMsgDTO getUserMsg(int userId) {
        UserMsgDTO userMsg = userMapper.getUserMsg(userId);
        userMsg.setPassword("*********************");
        return userMsg;
    }

    @Override
    public UserRelationDTO getUserRelation(String userName) {
        int userId=userMapper.findByName(userName).getUserId();
        UserRelationDTO dto = userMapper.getUserRelation(userId);
        /*喜欢功能待完善，暂时默认为0后续添加*/
        dto.setLiking(0);
        dto.setCommentNum(blogMapper.getCommentNumByUser(userId));
        return dto;
    }
}
