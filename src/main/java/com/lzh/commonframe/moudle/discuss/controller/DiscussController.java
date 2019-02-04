package com.lzh.commonframe.moudle.discuss.controller;

import com.lzh.commonframe.common.domain.CommonCommentReply;
import com.lzh.commonframe.common.domain.CommonCommentTopic;
import com.lzh.commonframe.common.domain.ResponseDTO;
import com.lzh.commonframe.moudle.discuss.domain.CommentReplies;
import com.lzh.commonframe.moudle.discuss.service.DiscussService;
import io.swagger.annotations.Api;
import org.apache.http.HttpRequest;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

@Api("评论API")
@Controller
@ResponseBody
public class DiscussController {

    @Autowired
    DiscussService discussService;

    @PostMapping("/article/comment/topic/add")
    public ResponseDTO addCommentToTopic(CommonCommentTopic commentTopic, HttpServletRequest request) {
        commentTopic.setFromUid((int)SecurityUtils.getSubject().getSession().getAttribute("userId"));
        commentTopic.setCommitTime(new Date());
        commentTopic.setCommitIp(request.getRemoteAddr());
        return discussService.addCommentToTopic(commentTopic);
    }

    @PostMapping("/article/comment/2level/add")
    public ResponseDTO addCommentToUser(CommentReplies commentReply, HttpServletRequest request) {
        commentReply.setCommitUserId((int)SecurityUtils.getSubject().getSession().getAttribute("userId"));
        commentReply.setCommitTime(new Date());
        commentReply.setCommitIp(request.getRemoteAddr());
        return discussService.addCommentToUser(commentReply);
    }

    @GetMapping("/article/comment/load/{topicId}")
    public ResponseDTO loadComments(@PathVariable int topicId){
        return discussService.loadComments(topicId);
    }
}
