package com.lzh.commonframe.common.mapper;

import com.lzh.commonframe.common.domain.CommonUserRoleKey;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CommonUserRoleMapper {
    @Delete({
        "delete from user_role",
        "where user_id = #{userId,jdbcType=INTEGER}",
          "and role_id = #{roleId,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(CommonUserRoleKey key);

    @Insert({
        "insert into user_role (user_id, role_id)",
        "values (#{userId,jdbcType=INTEGER}, #{roleId,jdbcType=INTEGER})"
    })
    int insert(CommonUserRoleKey record);

    @InsertProvider(type=CommonUserRoleSqlProvider.class, method="insertSelective")
    int insertSelective(CommonUserRoleKey record);
}