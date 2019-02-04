package com.lzh.commonframe.moudle.discuss.service;

import com.lzh.commonframe.common.domain.CommonCommentReply;
import com.lzh.commonframe.common.domain.CommonCommentTopic;
import com.lzh.commonframe.common.domain.ResponseDTO;
import com.lzh.commonframe.moudle.discuss.domain.CommentReplies;

public interface DiscussService {

    /*用户发布评论*/
    ResponseDTO addCommentToTopic(CommonCommentTopic commentTopic);

    /*用户回复评论*/
    ResponseDTO addCommentToUser(CommentReplies commentReply);

    /*评论的加载*/
    ResponseDTO loadComments(int topicId);

}
