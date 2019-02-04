<!doctype html>
<html lang="en">
<head>
    <link rel="shortcut icon" href="#" />
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="/static/css/bootstrap.min.css"  crossorigin="anonymous">
    <link rel="stylesheet" href="/static/css/common.css?v=1111111">
    <link rel="stylesheet" type="text/css" href="/static/css/writeblog.css?v=1111111" />

    <script src="/static/js/jquery-3.3.1.js"  crossorigin="anonymous"></script>

    <!-- Simditor -->
    <link rel="stylesheet" type="text/css" href="/static/smiditor/styles/simditor.css" />

    <title>Hello, world!</title>
</head>
<body>

<div class="container">
    <div class="container-fluid">
        <div class="row">
            <#include "uhead.ftl"/>
        </div>

        <div class="row">
            <div class="col-xl-12 row text-center ">
                <div class="txt-box col-xl-2"></div>
                <div class="txt-box col-xl-4">
                    <label class="labTitle col-form-label">文章类型：</label>
                    <select id="selType">
                        <option value="0">请选择</option>
                    </select>
                    <span class="required">*</span>
                </div>
                <div class="txt-box col-xl-4">
                    <label class="labTitle col-form-label">博客分类：</label>
                    <select class="droBlogType" id="radChl" name="radChl">
                        <option value="0">选择分类</option>
                    </select>
                    <span class="required">*</span>
                </div>
                <div class="txt-box col-xl-2"></div>
            </div>
        </div>

        <div>
            <input type="text" id="txtTitle"  placeholder="输入文章标题">
            <textarea id="editor" type="text/plain"  autofocus></textarea>
        </div>

        <div class="row">
            <div class="col-xl-12 row text-center">
                <div class="col-xl-4"></div>
                <div class="col-xl-2">
                    <input id="btnPublish" type="button" class="btn btn-outline-danger" value="发布文章" title="发布博客">
                </div>
                <div class="col-xl-2">
                    <input id="btnDraft" type="button" class="btn btn-outline-danger ml-24 btn-baocun" value="保存为草稿" title="保存为草稿">
                </div>
                <div class="col-xl-4"></div>
            </div>
        </div>

    </div>

</div>
<#--smiditor-->
<script type="text/javascript" src="/static/smiditor/scripts/module.js"></script>
<script type="text/javascript" src="/static/smiditor/scripts/hotkeys.js"></script>
<script type="text/javascript" src="/static/smiditor/scripts/uploader.js"></script>
<script type="text/javascript" src="/static/smiditor/scripts/simditor.js"></script>

<!-- Optional JavaScript -->
<!-- jQuery first, then Popper.js, then Bootstrap JS -->
<script src="/static/js/popper.min.js"  crossorigin="anonymous"></script>
<script src="/static/js/bootstrap.min.js"  crossorigin="anonymous"></script>
<script src="/static/js/common.js"  crossorigin="anonymous"></script>
<script src="/static/js/writeblog.js"  crossorigin="anonymous"></script>
</body>
</html>