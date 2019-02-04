package com.lzh.commonframe.moudle.user.mapper;

import com.lzh.commonframe.moudle.user.domain.UserMsgDTO;

import static org.apache.ibatis.jdbc.SqlBuilder.*;
import static org.apache.ibatis.jdbc.SqlBuilder.SQL;

public class UserSqlPrivoder {
    public String updateByPrimaryKeySelective(UserMsgDTO record) {
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

        WHERE("user_id = #{userId,jdbcType=INTEGER}");

        return SQL();
    }
}
