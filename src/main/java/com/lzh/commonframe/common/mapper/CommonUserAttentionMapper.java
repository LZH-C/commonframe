package com.lzh.commonframe.common.mapper;

import com.lzh.commonframe.common.domain.CommonUserAttention;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

@Mapper
public interface CommonUserAttentionMapper {
    @Delete({
        "delete from user_attention",
        "where a_id = #{aId,jdbcType=SMALLINT}"
    })
    int deleteByPrimaryKey(Short aId);

    @Insert({
        "insert into user_attention (a_id, user_id, ",
        "attention_id)",
        "values (#{aId,jdbcType=SMALLINT}, #{userId,jdbcType=INTEGER}, ",
        "#{attentionId,jdbcType=INTEGER})"
    })
    int insert(CommonUserAttention record);

    @InsertProvider(type=CommonUserAttentionSqlProvider.class, method="insertSelective")
    int insertSelective(CommonUserAttention record);

    @Select({
        "select",
        "a_id, user_id, attention_id",
        "from user_attention",
        "where a_id = #{aId,jdbcType=SMALLINT}"
    })
    @Results({
        @Result(column="a_id", property="aId", jdbcType=JdbcType.SMALLINT, id=true),
        @Result(column="user_id", property="userId", jdbcType=JdbcType.INTEGER),
        @Result(column="attention_id", property="attentionId", jdbcType=JdbcType.INTEGER)
    })
    CommonUserAttention selectByPrimaryKey(Short aId);

    @UpdateProvider(type=CommonUserAttentionSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(CommonUserAttention record);

    @Update({
        "update user_attention",
        "set user_id = #{userId,jdbcType=INTEGER},",
          "attention_id = #{attentionId,jdbcType=INTEGER}",
        "where a_id = #{aId,jdbcType=SMALLINT}"
    })
    int updateByPrimaryKey(CommonUserAttention record);
}