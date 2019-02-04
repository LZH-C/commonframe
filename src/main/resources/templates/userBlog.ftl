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
    <link rel="stylesheet" href="/static/css/userBlog.css?v=1131">
    <link rel="stylesheet" href="/static/css/userBlogListArticle.css?v=1131">
    <title>UserMsg</title>
</head>
<body>

<!-- Optional JavaScript -->
<!-- jQuery first, then Popper.js, then Bootstrap JS -->


<div class="container">
    <div class="container-fluid">
        <div class="row">
            <#include "uhead.ftl"/>
        </div>

        <div class="row">
            <aside style="width: 25%">
                <#include "userLeftWall.ftl"/>
            </aside>

            <aside style="width: 75%">
                <div id="asideProfile" class="aside-box">
                    <!-- <h3 class="aside-title">个人资料</h3> -->
                    <div class="profile-intro2 d-flex">
                        <form action="" id="seeOriginal">
                            <label class="chk-box" for="chkOriginal">
                                <input onchange="this.checked ? document.getElementById('seeOriginal').submit() : location.href = 'https://blog.csdn.net/qq_34187229'" type="checkbox" name="t" value="1" id="chkOriginal">只看原创
                            </label>
                        </form>
                        <dl class="filter-sort-box d-flex align-items-center">
                            <dt>排序：</dt>
                            <dd><a href="javascript:void(0);" class="btn-filter-sort active" sort-data="default" target="_self">默认</a></dd>
                            <dd><a href="javascript:void(0);" class="btn-filter-sort " sort-data="highTime" target="_self">按更新时间</a></dd>
                            <dd><a href="javascript:void(0);" class="btn-filter-sort " sort-data="highVisit" target="_self">按访问量</a></dd>
                        </dl>
                    </div>
                    <div class="data-info2">

                    </div>
                </div>
            </aside>
        </div>
        <#include "register_login.ftl"/>
    </div>

</div>
<script src="/static/js/jquery-3.3.1.js"  crossorigin="anonymous"></script>
<script src="/static/js/popper.min.js"  crossorigin="anonymous"></script>
<script src="/static/js/bootstrap.min.js"  crossorigin="anonymous"></script>
<script src="/static/js/common.js"  crossorigin="anonymous"></script>
<script src="/static/js/time.js"  crossorigin="anonymous"></script>
<script src="/static/js/validate.js"  crossorigin="anonymous"></script>
<script src="/static/js/userBlog.js"  crossorigin="anonymous"></script>
</body>
</html>