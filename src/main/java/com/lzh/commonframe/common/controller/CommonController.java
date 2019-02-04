package com.lzh.commonframe.common.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CommonController {

    //默认首页
    @GetMapping("/index")
    public String index(){
        return "index";
    }

    //错误页面展示
    @PostMapping("/error")
    public String error(){
        return "error";
    }

    //显示指定页面
    @GetMapping("/{page}")
    public String getPage(@PathVariable String page){
        return page;
    }

    //返回编写博客页面
    @GetMapping("/article/write")
    public String writeBlog(){
        return "writeblog";
    }

    //查看用户文章页面
    @GetMapping("/{userName}/article/details/{articleId}")
    public String getArticle(@PathVariable String userName, @PathVariable int articleId){
        return "lookBlog";
    }

    //获取用户博客主页
    @GetMapping("/blog/{userName}")
    public String getUserBlog(){
        return "userBlog";
    }

}
