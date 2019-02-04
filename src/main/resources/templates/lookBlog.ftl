<!doctype html>
<html lang="zh-CN">
<head>
    <!-- Required meta tags -->
    <link rel="shortcut icon" href="#" />
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="/static/css/bootstrap.min.css"  crossorigin="anonymous">
    <link rel="stylesheet" href="/static/css/common.css?v=1131">
    <link rel="stylesheet" href="/static/css/lookBlog.css?v=1131">
    <title>UserMsg</title>
</head>
<body>

<div class="container">
    <div class="container-fluid">
        <div class="row">
            <#include "head.ftl"/>
        </div>
        <div class="row">
            <aside style="width: 25%">
                <#include "userLeftWall.ftl"/>
            </aside>

            <aside style="width: 75%">
                <div id="asideProfile" class="aside-box">
                    <!-- <h3 class="aside-title">个人资料</h3> -->
                    <div class="profile-intro2">
                        <h3></h3>
                        <p>
                            <span class="time">2019年01月17日 16:48:53</span>
                            <span class="read-count">阅读数：2434</span>
                            <div id="userFunc" style="float: right;display: none">
                                <button id="change" onclick="changeArticle()" class="btn btn-primary">修改</button>
                                <button id="delete" onclick="delArticle()" c class="btn btn-danger">删除</button>
                            </div>
                        </p>
                    </div>
                    <div class="data-info2 ">

                    </div>
                </div>
            </aside>
        </div>
    <#--评论区域-->
        <div id="commentArea" class="row">
            <div class="col-xl-3"></div>
            <div class="col-xl-9">
                <div class="comment-box">
                    <div class="comment-edit-box d-flex">
                        <a id="commentsedit"></a>
                        <div class="user-img">
                            <a href="#" target="_blank">
                                <img class="" src="/static/img/logo.jpg">
                            </a>
                        </div>
                        <form id="commentform">
                            <input type="hidden" id="comment_replyId">
                            <input type="hidden" id="comment_replyUserName">
                            <textarea class="comment-content" name="comment_content" style="height: auto" id="comment_content" placeholder="想对作者说点什么"></textarea>
                            <div class="opt-box"  id="comment_detail" > <!-- d-flex -->
                                <div id="ubbtools" class="add_code">
                                    <a href="#insertcode" code="code" target="_self">
                                        <i class="icon iconfont icon-daima"></i></a>
                                </div>
                                <div style="display: none;"data-mod="popu_384"><a href="#" target="_blank" class="comment_area_btn">发表评论</a></div>
                                <div class="right-box">
                                    <span id="tip_comment" class="tip">还能输入<em>1000</em>个字符</span>
                                    <input id="addArticleComment" type="button" onclick="addComment()" data-toggle="modal" data-target="#login" class="btn btn-sm btn-red btn-comment" value="发表评论">
                                </div>
                            </div>
                        </form>
                    </div>

                    <div class="comment-list-container">
                        <div class="comment-box">
                            <div class="comment-list-container">
                                <a id="comments"></a>
                                <div id="commentList" class="comment-list-box">
                                    <div id="commentPage" class="pagination-box" style="display: block;">
                                        <div id="Paging_03025950359855145" class="ui-paging-container">
                                            <ul>
                                                <li class="js-page-first js-page-action ui-pager ui-pager-disabled"></li>
                                                <li class="js-page-prev js-page-action ui-pager ui-pager-disabled">上一页</li>
                                                <li data-page="1" class="ui-pager focus">1</li>
                                                <li data-page="2" class="ui-pager">2</li>
                                                <li class="js-page-next js-page-action ui-pager">下一页</li>
                                                <li class="js-page-last js-page-action ui-pager"></li>
                                            </ul>
                                        </div>
                                    </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>

        </div>
        <#include "register_login.ftl"/>
    </div>

</div>
<!-- Optional JavaScript -->
<!-- jQuery first, then Popper.js, then Bootstrap JS -->
<script src="/static/js/jquery-3.3.1.js"  crossorigin="anonymous"></script>
<script src="/static/js/popper.min.js"  crossorigin="anonymous"></script>
<script src="/static/js/bootstrap.min.js"  crossorigin="anonymous"></script>
<script src="/static/js/common.js"  crossorigin="anonymous"></script>
<script src="/static/js/time.js"  crossorigin="anonymous"></script>
<script src="/static/js/validate.js"  crossorigin="anonymous"></script>
<script src="/static/js/lookBlog.js"  crossorigin="anonymous"></script>
</body>
</html>