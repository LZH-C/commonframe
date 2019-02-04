package com.lzh.commonframe.moudle.discuss.domain;

import com.lzh.commonframe.common.domain.CommonCommentReply;

import java.util.Date;

public class CommentReplies extends CommonCommentReply {

    private String replyName;

    private String beReplyName;//被回复者

    private String userImageUrl;

    private Date commitTime;

    public String getReplyName() {
        return replyName;
    }

    public void setReplyName(String replyName) {
        this.replyName = replyName;
    }

    public String getBeReplyName() {
        return beReplyName;
    }

    public void setBeReplyName(String beReplyName) {
        this.beReplyName = beReplyName;
    }

    public String getUserImageUrl() {
        return userImageUrl;
    }

    public void setUserImageUrl(String userImageUrl) {
        this.userImageUrl = userImageUrl;
    }

    public Date getCommitTime() {
        return commitTime;
    }

    public void setCommitTime(Date commitTime) {
        this.commitTime = commitTime;
    }
}
