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
                    <li class="router-link-exact-active router-link-active">
                        <a href="JavaScript:reLoading('/userCollect');" class="zl">我的收藏</a>
                    </li>
                    <li class="">
                        <a href="JavaScript:reLoading('/userFollow');" class="zl">我的关注</a>
                    </li>
                    <li class="">
                        <a href="JavaScript:reLoading('/userFans');" class="zl">我的粉丝</a>
                    </li>
                    <li>
                        <a href="JavaScript:reLoading('/userBlog');" target="_blank" class="zl">我的博客</a>
                    </li>
                </ul>
            </div>
            <div class="col-xl-10 view-container">
                <div   class="my_fav clearfix view">
                    <div  class="my_fav_t"><h3 >我的收藏</h3> <!----></div>
                    <div  class="my_fav_con">
                        <div  class="blank_list"><img  src="">
                            <div  class="blank_tips">空空如也</div>
                        </div>
                    </div>
                    <div  class="my_fav_con">
                        <div >
                            <ul  class="my_fav_list clearfix">
                                <li  id="20608242"><a href="https://blog.csdn.net/weixin_44224288/article/details/86528439" target="_blank">linux下的网络配置 -
                                    weixin_44224288的博客</a> <label ><span
                                        >2019-01-19</span> <em  class="cancel_fav">取消</em></label>
                                </li>
                            </ul> <!----></div>
                    </div>
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