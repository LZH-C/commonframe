package com.lzh.commonframe.common.domain;

import java.util.Date;

public class CommonCommentTopic {
    private Integer commentId;

    private Integer topicId;

    private String content;

    private Integer fromUid;

    private Date commitTime;

    private String commitIp;

    public Integer getCommentId() {
        return commentId;
    }

    public void setCommentId(Integer commentId) {
        this.commentId = commentId;
    }

    public Integer getTopicId() {
        return topicId;
    }

    public void setTopicId(Integer topicId) {
        this.topicId = topicId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public Integer getFromUid() {
        return fromUid;
    }

    public void setFromUid(Integer fromUid) {
        this.fromUid = fromUid;
    }

    public Date getCommitTime() {
        return commitTime;
    }

    public void setCommitTime(Date commitTime) {
        this.commitTime = commitTime;
    }

    public String getCommitIp() {
        return commitIp;
    }

    public void setCommitIp(String commitIp) {
        this.commitIp = commitIp == null ? null : commitIp.trim();
    }
}