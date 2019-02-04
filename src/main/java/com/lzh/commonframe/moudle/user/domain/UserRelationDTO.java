package com.lzh.commonframe.moudle.user.domain;

public class UserRelationDTO {
/*用户左边框关系信息 包含原创数，关注数，点击数，评论数，喜欢数*/
    private int original;

    private int attention;

    private int click;

    private int commentNum;

    private int liking;

    public int getOriginal() {
        return original;
    }

    public void setOriginal(int original) {
        this.original = original;
    }

    public int getAttention() {
        return attention;
    }

    public void setAttention(int attention) {
        this.attention = attention;
    }

    public int getClick() {
        return click;
    }

    public void setClick(int click) {
        this.click = click;
    }

    public int getCommentNum() {
        return commentNum;
    }

    public void setCommentNum(int commentNum) {
        this.commentNum = commentNum;
    }

    public int getLiking() {
        return liking;
    }

    public void setLiking(int liking) {
        this.liking = liking;
    }
}
