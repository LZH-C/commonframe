package com.lzh.commonframe.moudle.discuss.service;

import com.lzh.commonframe.common.domain.CommonCommentReply;
import com.lzh.commonframe.common.domain.CommonCommentTopic;
import com.lzh.commonframe.common.domain.ResponseDTO;
import com.lzh.commonframe.common.mapper.CommonCommentReplyMapper;
import com.lzh.commonframe.common.mapper.CommonCommentTopicMapper;
import com.lzh.commonframe.moudle.discuss.domain.CommentDTO;
import com.lzh.commonframe.moudle.discuss.domain.CommentReplies;
import com.lzh.commonframe.moudle.discuss.mapper.DiscussMapper;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DiscussServiceImpl implements DiscussService{

    @Autowired
    CommonCommentTopicMapper topicMapper;
    @Autowired
    CommonCommentReplyMapper replyMapper;
    @Autowired
    DiscussMapper discussMapper;

    @Override
    public ResponseDTO addCommentToTopic(CommonCommentTopic commentTopic) {
        commentTopic.setFromUid((int)SecurityUtils.getSubject().getSession().getAttribute("userId"));
        int i=topicMapper.insert(commentTopic);
        if(i!=0){
            return ResponseDTO.succData("回复主题成功");
        }
        return ResponseDTO.succData("回复主题失败");
    }

    @Override
    public ResponseDTO loadComments(int topicId) {
        List<CommentDTO> comments = discussMapper.loadTopicComment(topicId);
        for(CommentDTO comment:comments){
            comment.setCommentReplies(discussMapper.loadReplyComments(comment.getCommentId()));
        }
        return new ResponseDTO("评论加载成功",comments);
    }

    @Override
    public ResponseDTO addCommentToUser(CommentReplies commentReply) {
        int i=discussMapper.addCommentToUser(commentReply);
        if(i!=0){
            return ResponseDTO.succData("回复评论成功");
        }
        return ResponseDTO.succData("回复评论失败");
    }
}
