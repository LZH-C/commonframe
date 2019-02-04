package com.lzh.commonframe.moudle.discuss.domain;

import com.lzh.commonframe.common.domain.CommonCommentTopic;

import java.util.Date;

public class CommentTopic extends CommonCommentTopic {

    private String userName;

    private String userImageUrl;

    private Date commitTime;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
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
