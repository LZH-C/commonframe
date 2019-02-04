package com.lzh.commonframe.common.mapper;

import com.lzh.commonframe.common.domain.CommonUser;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

@Mapper
public interface CommonUserMapper {
    @Delete({
        "delete from user",
        "where user_id = #{userId,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer userId);

    @Insert({
        "insert into user (user_id, user_name, ",
        "password, email, ",
        "user_phone, user_real_name, ",
        "user_trade, user_position, ",
        "user_area, user_birth, ",
        "user_gender, user_image_url, ",
        "user_description, user_register_time, ",
        "user_register_ip, user_last_login_ip, ",
        "user_last_login_time, user_last_update_time, ",
        "salt, user_lock, ",
        "user_freeze)",
        "values (#{userId,jdbcType=INTEGER}, #{userName,jdbcType=VARCHAR}, ",
        "#{password,jdbcType=VARCHAR}, #{email,jdbcType=VARCHAR}, ",
        "#{userPhone,jdbcType=INTEGER}, #{userRealName,jdbcType=VARCHAR}, ",
        "#{userTrade,jdbcType=VARCHAR}, #{userPosition,jdbcType=VARCHAR}, ",
        "#{userArea,jdbcType=VARCHAR}, #{userBirth,jdbcType=DATE}, ",
        "#{userGender,jdbcType=VARCHAR}, #{userImageUrl,jdbcType=VARCHAR}, ",
        "#{userDescription,jdbcType=VARCHAR}, #{userRegisterTime,jdbcType=TIMESTAMP}, ",
        "#{userRegisterIp,jdbcType=VARCHAR}, #{userLastLoginIp,jdbcType=VARCHAR}, ",
        "#{userLastLoginTime,jdbcType=TIMESTAMP}, #{userLastUpdateTime,jdbcType=TIMESTAMP}, ",
        "#{salt,jdbcType=VARCHAR}, #{userLock,jdbcType=TINYINT}, ",
        "#{userFreeze,jdbcType=TINYINT})"
    })
    int insert(CommonUser record);

    @InsertProvider(type=CommonUserSqlProvider.class, method="insertSelective")
    int insertSelective(CommonUser record);

    @Select({
        "select",
        "user_id, user_name, password, email, user_phone, user_real_name, user_trade, ",
        "user_position, user_area, user_birth, user_gender, user_image_url, user_description, ",
        "user_register_time, user_register_ip, user_last_login_ip, user_last_login_time, ",
        "user_last_update_time, salt, user_lock, user_freeze",
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
    CommonUser selectByPrimaryKey(Integer userId);

    @UpdateProvider(type=CommonUserSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(CommonUser record);

    @Update({
        "update user",
        "set user_name = #{userName,jdbcType=VARCHAR},",
          "password = #{password,jdbcType=VARCHAR},",
          "email = #{email,jdbcType=VARCHAR},",
          "user_phone = #{userPhone,jdbcType=INTEGER},",
          "user_real_name = #{userRealName,jdbcType=VARCHAR},",
          "user_trade = #{userTrade,jdbcType=VARCHAR},",
          "user_position = #{userPosition,jdbcType=VARCHAR},",
          "user_area = #{userArea,jdbcType=VARCHAR},",
          "user_birth = #{userBirth,jdbcType=DATE},",
          "user_gender = #{userGender,jdbcType=VARCHAR},",
          "user_image_url = #{userImageUrl,jdbcType=VARCHAR},",
          "user_description = #{userDescription,jdbcType=VARCHAR},",
          "user_register_time = #{userRegisterTime,jdbcType=TIMESTAMP},",
          "user_register_ip = #{userRegisterIp,jdbcType=VARCHAR},",
          "user_last_login_ip = #{userLastLoginIp,jdbcType=VARCHAR},",
          "user_last_login_time = #{userLastLoginTime,jdbcType=TIMESTAMP},",
          "user_last_update_time = #{userLastUpdateTime,jdbcType=TIMESTAMP},",
          "salt = #{salt,jdbcType=VARCHAR},",
          "user_lock = #{userLock,jdbcType=TINYINT},",
          "user_freeze = #{userFreeze,jdbcType=TINYINT}",
        "where user_id = #{userId,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(CommonUser record);
}