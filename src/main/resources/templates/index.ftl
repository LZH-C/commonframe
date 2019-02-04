<!doctype html>
<html lang="zh-CN">
<head>
    <link rel="shortcut icon" href="#" />
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="/static/css/bootstrap.min.css"  crossorigin="anonymous">
    <link rel="stylesheet" href="/static/css/common.css?v=111">
    <link rel="stylesheet" href="/static/css/index.css?v=11111">
    <link rel="stylesheet" href="/static/css/listArticle.css?v=11111">
    <title>Blog首页</title>
</head>
<body>

<div class="container">
    <div class="container-fluid">
        <div class="row">
            <#include "head.ftl"/>
        </div>

        <div class="row">
            <div class="col-sm-12 col-md-12 col-lg-12 col-xl-12">
                <img src="/static/img/index.png" style="width: 100%;height: auto">
            </div>
        </div>

        <div class="row">
            <div class="col-sm-2 col-md-2 col-lg-2 col-xl-2">
                <p>文章列表:</p>
            </div>
            <div class="col-sm-5 col-md-5 col-lg-5 col-xl-5">

            </div>
            <div class="col-sm-5 col-md-5 col-lg-5 col-xl-5" >

            </div>

        </div>

        <div class="row">
            <div class="col-xl-12 justify-content-center" >
            <main>
            <ul class="feedlist_mod home" id="feedlist_id" shown-offset="1548491689013045" style="padding-top: 0px;">

            </ul>
            </main>
            </div>
        </div>

        <div  class="row">
            <div id="article">
                <ul class="pagination">
                    <#--<li class="page-item" id="toBegin"><a class="page-link" href="#">&laquo;</a></li>
                    <li class="page-item"><a class="page-link" href="#">1</a></li>
                    <li class="page-item"><a class="page-link" href="#">2</a></li>
                    <li class="page-item"><a class="page-link" href="#">3</a></li>
                    <li class="page-item"><a class="page-link" href="#">...</a></li>
                    <li class="page-item" id="toEnd"><a class="page-link" href="#">&raquo;</a></li>-->
                </ul>
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
<script src="/static/js/validate.js"  crossorigin="anonymous"></script>
<script src="/static/js/index.js"  crossorigin="anonymous"></script>
</body>
</html>