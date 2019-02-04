package com.lzh.commonframe.moudle.discuss.domain;

import com.lzh.commonframe.common.domain.CommonCommentReply;
import com.lzh.commonframe.common.domain.CommonCommentTopic;

import java.util.List;

public class CommentDTO extends CommentTopic {

    private List<CommentReplies> commentReplies;

    public List<CommentReplies> getCommentReplies() {
        return commentReplies;
    }

    public void setCommentReplies(List<CommentReplies> commentReplies) {
        this.commentReplies = commentReplies;
    }
}
