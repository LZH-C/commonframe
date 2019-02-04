package com.lzh.commonframe.common.mapper;

import static org.apache.ibatis.jdbc.SqlBuilder.BEGIN;
import static org.apache.ibatis.jdbc.SqlBuilder.INSERT_INTO;
import static org.apache.ibatis.jdbc.SqlBuilder.SET;
import static org.apache.ibatis.jdbc.SqlBuilder.SQL;
import static org.apache.ibatis.jdbc.SqlBuilder.UPDATE;
import static org.apache.ibatis.jdbc.SqlBuilder.VALUES;
import static org.apache.ibatis.jdbc.SqlBuilder.WHERE;

import com.lzh.commonframe.common.domain.CommonUser;

public class CommonUserSqlProvider {

    public String insertSelective(CommonUser record) {
        BEGIN();
        INSERT_INTO("user");
        
        if (record.getUserId() != null) {
            VALUES("user_id", "#{userId,jdbcType=INTEGER}");
        }
        
        if (record.getUserName() != null) {
            VALUES("user_name", "#{userName,jdbcType=VARCHAR}");
        }
        
        if (record.getPassword() != null) {
            VALUES("password", "#{password,jdbcType=VARCHAR}");
        }
        
        if (record.getEmail() != null) {
            VALUES("email", "#{email,jdbcType=VARCHAR}");
        }
        
        if (record.getUserPhone() != null) {
            VALUES("user_phone", "#{userPhone,jdbcType=INTEGER}");
        }
        
        if (record.getUserRealName() != null) {
            VALUES("user_real_name", "#{userRealName,jdbcType=VARCHAR}");
        }
        
        if (record.getUserTrade() != null) {
            VALUES("user_trade", "#{userTrade,jdbcType=VARCHAR}");
        }
        
        if (record.getUserPosition() != null) {
            VALUES("user_position", "#{userPosition,jdbcType=VARCHAR}");
        }
        
        if (record.getUserArea() != null) {
            VALUES("user_area", "#{userArea,jdbcType=VARCHAR}");
        }
        
        if (record.getUserBirth() != null) {
            VALUES("user_birth", "#{userBirth,jdbcType=DATE}");
        }
        
        if (record.getUserGender() != null) {
            VALUES("user_gender", "#{userGender,jdbcType=VARCHAR}");
        }
        
        if (record.getUserImageUrl() != null) {
            VALUES("user_image_url", "#{userImageUrl,jdbcType=VARCHAR}");
        }
        
        if (record.getUserDescription() != null) {
            VALUES("user_description", "#{userDescription,jdbcType=VARCHAR}");
        }
        
        if (record.getUserRegisterTime() != null) {
            VALUES("user_register_time", "#{userRegisterTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getUserRegisterIp() != null) {
            VALUES("user_register_ip", "#{userRegisterIp,jdbcType=VARCHAR}");
        }
        
        if (record.getUserLastLoginIp() != null) {
            VALUES("user_last_login_ip", "#{userLastLoginIp,jdbcType=VARCHAR}");
        }
        
        if (record.getUserLastLoginTime() != null) {
            VALUES("user_last_login_time", "#{userLastLoginTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getUserLastUpdateTime() != null) {
            VALUES("user_last_update_time", "#{userLastUpdateTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getSalt() != null) {
            VALUES("salt", "#{salt,jdbcType=VARCHAR}");
        }
        
        if (record.getUserLock() != null) {
            VALUES("user_lock", "#{userLock,jdbcType=TINYINT}");
        }
        
        if (record.getUserFreeze() != null) {
            VALUES("user_freeze", "#{userFreeze,jdbcType=TINYINT}");
        }
        
        return SQL();
    }

    public String updateByPrimaryKeySelective(CommonUser record) {
        BEGIN();
        UPDATE("user");
        
        if (record.getUserName() != null) {
            SET("user_name = #{userName,jdbcType=VARCHAR}");
        }
        
        if (record.getPassword() != null) {
            SET("password = #{password,jdbcType=VARCHAR}");
        }
        
        if (record.getEmail() != null) {
            SET("email = #{email,jdbcType=VARCHAR}");
        }
        
        if (record.getUserPhone() != null) {
            SET("user_phone = #{userPhone,jdbcType=INTEGER}");
        }
        
        if (record.getUserRealName() != null) {
            SET("user_real_name = #{userRealName,jdbcType=VARCHAR}");
        }
        
        if (record.getUserTrade() != null) {
            SET("user_trade = #{userTrade,jdbcType=VARCHAR}");
        }
        
        if (record.getUserPosition() != null) {
            SET("user_position = #{userPosition,jdbcType=VARCHAR}");
        }
        
        if (record.getUserArea() != null) {
            SET("user_area = #{userArea,jdbcType=VARCHAR}");
        }
        
        if (record.getUserBirth() != null) {
            SET("user_birth = #{userBirth,jdbcType=DATE}");
        }
        
        if (record.getUserGender() != null) {
            SET("user_gender = #{userGender,jdbcType=VARCHAR}");
        }
        
        if (record.getUserImageUrl() != null) {
            SET("user_image_url = #{userImageUrl,jdbcType=VARCHAR}");
        }
        
        if (record.getUserDescription() != null) {
            SET("user_description = #{userDescription,jdbcType=VARCHAR}");
        }
        
        if (record.getUserRegisterTime() != null) {
            SET("user_register_time = #{userRegisterTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getUserRegisterIp() != null) {
            SET("user_register_ip = #{userRegisterIp,jdbcType=VARCHAR}");
        }
        
        if (record.getUserLastLoginIp() != null) {
            SET("user_last_login_ip = #{userLastLoginIp,jdbcType=VARCHAR}");
        }
        
        if (record.getUserLastLoginTime() != null) {
            SET("user_last_login_time = #{userLastLoginTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getUserLastUpdateTime() != null) {
            SET("user_last_update_time = #{userLastUpdateTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getSalt() != null) {
            SET("salt = #{salt,jdbcType=VARCHAR}");
        }
        
        if (record.getUserLock() != null) {
            SET("user_lock = #{userLock,jdbcType=TINYINT}");
        }
        
        if (record.getUserFreeze() != null) {
            SET("user_freeze = #{userFreeze,jdbcType=TINYINT}");
        }
        
        WHERE("user_id = #{userId,jdbcType=INTEGER}");
        
        return SQL();
    }
}