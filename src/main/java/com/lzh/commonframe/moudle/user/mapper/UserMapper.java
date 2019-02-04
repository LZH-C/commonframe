package com.lzh.commonframe.moudle.user.mapper;

import com.lzh.commonframe.common.domain.CommonUser;
import com.lzh.commonframe.moudle.user.domain.*;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

@Mapper
public interface UserMapper {

    /*添加新用户*/
    @Insert("insert into user(user_name,password) values(#{userName,jdbcType=VARCHAR}, #{password,jdbcType=VARCHAR})")
    int addUser(CommonUser user);

    /*删除用户*/
    @Delete("delete user where user_name=#{userName,jdbcType=VARCHAR}")
    int delUser(String userName);

    /*修改用户密码*/
    @Update("update user set password=#{password,jdbcType=VARCHAR} where user_name=#{userName,jdbcType=VARCHAR}")
    int updatePassword(User user);

    /*根据用户名查询用户*/
    @Select("select * from user where user_name=#{userName,jdbcType=VARCHAR}")
    @Results({
            @Result(column="user_id", property="userId", jdbcType=JdbcType.INTEGER, id=true),
            @Result(column="user_name", property="userName", jdbcType=JdbcType.VARCHAR),
            @Result(column="password", property="password", jdbcType=JdbcType.VARCHAR),
            @Result(column="email", property="email", jdbcType=JdbcType.VARCHAR),
            @Result(column="user_phone", property="userPhone", jdbcType=JdbcType.INTEGER),
            @Result(column="user_real_name", property="userRealName", jdbcType=JdbcType.VARCHAR),
            @Result(column="user_trade", property="userTrade", jdbcType=JdbcType.VARCHAR),
            @Result(column="user_position", property="userPosition", jdbcType=JdbcType.VARCHAR),
            @Result(column="user_area", property="userArea", jdbcType=JdbcType.VARCHAR),
            @Result(column="user_birth", property="userBirth", jdbcType=JdbcType.DATE),
            @Result(column="user_gender", property="userGender", jdbcType=JdbcType.VARCHAR),
            @Result(column="user_image_url", property="userImageUrl", jdbcType=JdbcType.VARCHAR),
            @Result(column="user_description", property="userDescription", jdbcType=JdbcType.VARCHAR),
            @Result(column="user_register_time", property="userRegisterTime", jdbcType=JdbcType.TIMESTAMP),
            @Result(column="user_register_ip", property="userRegisterIp", jdbcType=JdbcType.VARCHAR),
            @Result(column="user_last_login_ip", property="userLastLoginIp", jdbcType=JdbcType.VARCHAR),
            @Result(column="user_last_login_time", property="userLastLoginTime", jdbcType=JdbcType.TIMESTAMP),
            @Result(column="user_last_update_time", property="userLastUpdateTime", jdbcType=JdbcType.TIMESTAMP),
            @Result(column="salt", property="salt", jdbcType=JdbcType.VARCHAR),
            @Result(column="user_lock", property="userLock", jdbcType=JdbcType.TINYINT),
            @Result(column="user_freeze", property="userFreeze", jdbcType=JdbcType.TINYINT)
    })
    CommonUser findByName(String userName);

    /*
    * 登录用户
    * 包含用户名和密码
    * */
    @Select({
            "select",
            "user_id, user_name, password, email, user_phone, user_gender, user_image_url, ",
            "user_description, user_register_time, user_register_ip, user_last_login_ip, ",
            "user_last_login_time, user_last_update_time, salt, user_lock, user_freeze",
            "from user",
            "where user_name=#{userName,jdbcType=VARCHAR} and password=#{password,jdbcType=VARCHAR}"
            })
    @Results({
            @Result(column="user_id", property="userId", jdbcType= JdbcType.INTEGER, id=true),
            @Result(column="user_name", property="userName", jdbcType=JdbcType.VARCHAR),
            @Result(column="password", property="password", jdbcType=JdbcType.VARCHAR),
            @Result(column="email", property="email", jdbcType=JdbcType.VARCHAR),
            @Result(column="user_phone", property="userPhone", jdbcType=JdbcType.INTEGER),
            @Result(column="user_gender", property="userGender", jdbcType=JdbcType.VARCHAR),
            @Result(column="user_image_url", property="userImageUrl", jdbcType=JdbcType.VARCHAR),
            @Result(column="user_description", property="userDescription", jdbcType=JdbcType.VARCHAR),
            @Result(column="user_register_time", property="userRegisterTime", jdbcType=JdbcType.TIMESTAMP),
            @Result(column="user_register_ip", property="userRegisterIp", jdbcType=JdbcType.VARCHAR),
            @Result(column="user_last_login_ip", property="userLastLoginIp", jdbcType=JdbcType.VARCHAR),
            @Result(column="user_last_login_time", property="userLastLoginTime", jdbcType=JdbcType.TIMESTAMP),
            @Result(column="user_last_update_time", property="userLastUpdateTime", jdbcType=JdbcType.TIMESTAMP),
            @Result(column="salt", property="salt", jdbcType=JdbcType.VARCHAR),
            @Result(column="user_lock", property="userLock", jdbcType=JdbcType.TINYINT),
            @Result(column="user_freeze", property="userFreeze", jdbcType=JdbcType.TINYINT)
    })
    CommonUser login(UserLoginDTO user);

    @Insert({
            "insert into user (user_name, password, email, ",
            "user_phone,user_image_url, user_register_time, user_register_ip, salt, ",
            "user_lock, user_freeze)",
            "values (#{userName,jdbcType=VARCHAR}, #{password,jdbcType=VARCHAR}, #{email,jdbcType=VARCHAR}, ",
            "#{userPhone,jdbcType=INTEGER},#{userImageUrl,jdbcType=VARCHAR}, ",
            "#{userRegisterTime,jdbcType=TIMESTAMP}, #{userRegisterIp,jdbcType=VARCHAR}, #{salt,jdbcType=VARCHAR}, ",
            "#{userLock,jdbcType=TINYINT}, #{userFreeze,jdbcType=TINYINT})"
    })
    int register(UserAddDTO user);

    @InsertProvider(type = UserSqlPrivoder.class,method = "updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(UserMsgDTO user);

    /*获取用户主要信息*/
    @Select({
            "select",
            "user_id, user_name, password, email, user_phone, user_real_name, user_trade, ",
            "user_position, user_area, user_birth, user_gender, user_image_url, user_description ",
            "from user",
            "where user_id = #{userId,jdbcType=INTEGER}"
    })
    @Results({
            @Result(column="user_id", property="userId", jdbcType=JdbcType.INTEGER, id=true),
            @Result(column="user_name", property="userName", jdbcType=JdbcType.VARCHAR),
            @Result(column="password", property="password", jdbcType=JdbcType.VARCHAR),
            @Result(column="email", property="email", jdbcType=JdbcType.VARCHAR),
            @Result(column="user_phone", property="userPhone", jdbcType=JdbcType.INTEGER),
            @Result(column="user_real_name", property="userRealName", jdbcType=JdbcType.VARCHAR),
            @Result(column="user_trade", property="userTrade", jdbcType=JdbcType.VARCHAR),
            @Result(column="user_position", property="userPosition", jdbcType=JdbcType.VARCHAR),
            @Result(column="user_area", property="userArea", jdbcType=JdbcType.VARCHAR),
            @Result(column="user_birth", property="userBirth", jdbcType=JdbcType.DATE),
            @Result(column="user_gender", property="userGender", jdbcType=JdbcType.VARCHAR),
            @Result(column="user_image_url", property="userImageUrl", jdbcType=JdbcType.VARCHAR),
            @Result(column="user_description", property="userDescription", jdbcType=JdbcType.VARCHAR)
    })
    UserMsgDTO getUserMsg(int userId);

    /*获取用户原创，关注，访问数*/
    @Select("select t.original,t.click,\n" +
            "(select count(u_att.user_id) from user_attention u_att \n" +
            "where u_att.user_id=#{userId,jdbcType=INTEGER}) as attention\n" +
            "from (select count(atc.article_id) as original ,sum(atc.article_click) as click from article atc\n" +
            "where atc.user_id=#{userId,jdbcType=INTEGER}\n" +
            "and atc.sort_article_id='1') as t")
    @Results({
            @Result(column="original", property="original", jdbcType=JdbcType.INTEGER),
            @Result(column="click", property="click", jdbcType=JdbcType.INTEGER),
            @Result(column="attention", property="attention", jdbcType=JdbcType.INTEGER),
    })
    UserRelationDTO getUserRelation(int userId);

}
