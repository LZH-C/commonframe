<!doctype html>
<html lang="zh-CN">
<head>
    <link rel="shortcut icon" href="#" />
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="/static/css/bootstrap.min.css"  crossorigin="anonymous">
    <link rel="stylesheet" href="/static/css/common.css?v=1131">
    <link rel="stylesheet" href="/static/css/userCollect.css?v=1131">
    <title>UserMsg</title>
</head>
<body>



<div class="container">
    <div class="container-fluid">
        <div class="row">
            <#include "uhead.ftl"/>
        </div>

        <div class="row">
            <div class="col-xl-2 left_box">
                <ul class="aside">
                    <li >
                        <a href="JavaScript:reLoading('/userMsg');" class="zl">个人资料</a>
                    </li>
                    <li class="">
                        <a href="JavaScript:reLoading('/userCollect');" class="zl">我的收藏</a>
                    </li>
                    <li class="">
                        <a href="JavaScript:reLoading('/userFollow');" class="zl">我的关注</a>
                    </li>
                    <li class="router-link-exact-active router-link-active">
                        <a href="JavaScript:reLoading('/userFans');" class="zl">我的粉丝</a>
                    </li>
                    <li>
                        <a href="JavaScript:reLoading('/userBlog');" target="_blank" class="zl">我的博客</a>
                    </li>
                </ul>
            </div>
            <div class="col-xl-10 view-container">
                <div   class="my_fav clearfix view">
                    <div  class="my_fav_t"><h3 >我的粉丝</h3> <!----></div>
                    <div  class="my_fav_con">
                        <div  class="blank_list"><img  src="">
                            <div  class="blank_tips">空空如也</div>
                        </div>
                    </div>
                    <ul data-v-0c56b7f6="" class="watch_list">
                        <li data-v-0c56b7f6="" class="item_cont"><a data-v-0c56b7f6="" href="//me.csdn.net/pearl8899"
                                                                    target="_blank" class="fans"><img data-v-0c56b7f6=""
                                                                                                      src="/static/img/logo.jpg"
                                                                                                      alt=""
                                                                                                      class="header"></a>
                            <a data-v-0c56b7f6="" href="//me.csdn.net/pearl8899" title="pearl8899" target="_blank"
                               class="nick">凝眸伏笔</a> <a data-v-0c56b7f6="" href="javascript:void (0)" class="watch_btn">取消关注</a>
                        </li>
                    </ul>
                </div>
            </div>
        </div>

    </div>

</div>
<!-- Optional JavaScript -->
<!-- jQuery first, then Popper.js, then Bootstrap JS -->
<script src="/static/js/jquery-3.3.1.js"  crossorigin="anonymous"></script>
<script src="/static/js/popper.min.js"  crossorigin="anonymous"></script>
<script src="/static/js/bootstrap.min.js"  crossorigin="anonymous"></script>
<script src="/static/js/common.js"  crossorigin="anonymous"></script>
</body>
</html>