package com.lzh.commonframe.moudle.blog.mapper;

import com.lzh.commonframe.moudle.blog.domain.UpdateArticleMsgDTO;

import static org.apache.ibatis.jdbc.SqlBuilder.*;
import static org.apache.ibatis.jdbc.SqlBuilder.SQL;

public class BlogSqlProvider {

    public String updateByPrimaryKeySelective(UpdateArticleMsgDTO record) {
        BEGIN();
        UPDATE("article");

        if (record.getArticleName() != null) {
            SET("article_name = #{articleName,jdbcType=VARCHAR}");
        }

        if (record.getSortArticleId() != null) {
            SET("sort_article_id = #{sortArticleId,jdbcType=INTEGER}");
        }

        if (record.getSortBlogId() != null) {
            SET("sort_bolg_id = #{sortBlogId,jdbcType=INTEGER}");
        }

        if (record.getArticleContent() != null) {
            SET("article_content = #{articleContent,jdbcType=LONGVARCHAR}");
        }

        if (record.getArticleTime() != null) {
            SET("article_time = #{articleTime,jdbcType=TIMESTAMP}");
        }

        WHERE("article_id = #{articleId,jdbcType=INTEGER}");

        return SQL();
    }
}
