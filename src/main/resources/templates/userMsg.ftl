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
    <link rel="stylesheet" href="/static/css/userMsg.css?v=1131">
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
                    <li class="router-link-exact-active router-link-active">
                        <a href="JavaScript:reLoading('/userMsg');" class="zl">个人资料</a>
                    </li>
                    <li class="">
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
                <div class="cont view">
                    <div class="right_cont">
                        <h3 class="title">个人资料</h3>
                        <div class="user_info">
                            <div class="header">
                                <img src="/static/img/logo.jpg" id="imgHead"
                                     class="head">
                                <p id="changeImgHead" class="modify">修改头像</p>
                                <input type="file" id="input_upload_driver" style="display: none" accept="image/jpg, image/png, image/jpeg" >
                            </div> <!---->
                            <div class="right_c">
                                <div class="right_info">
                                    <div class="id_card"><span
                                            class="id_name">ID：undenfine</span>
                                        <!----> <!----> <a href="#"
                                                           target="_blank" class="user_home">个人主页</a></div>
                                </div>
                                <div class="csdn_info">
                                    <span style="margin-right: 16px; color: rgb(77, 77, 77); font-size: 14px;">关注 0</span>
                                    <span style="margin-right: 16px; color: rgb(77, 77, 77); font-size: 14px;">粉丝 0</span>
                                </div>
                                <div class="line"></div>
                                <div class="nick">
                                    <span class="mod">
                                        <a class="nav-link" href="#" data-toggle="modal" data-target="#changeMsg">修改资料</a>
                                    </span>
                                </div>
                                <ul class="self">
                                    <li id="li-userRealName" class="comon">实名：</li>
                                    <li id="li-userGender" class="comon">性别：</li>
                                    <li id="li-userBirth" class="comon">生日：</li>
                                    <li id="li-userArea" class="comon">地区：</li>
                                    <li id="li-userTrade" class="comon">行业：</li>
                                    <li id="li-userPosition" class="comon last">职位：</li>
                                    <li class="intro">
                                        <span class="noWid">简介：</span>
                                        <span id="li-userDescription"  class="cont"></span>
                                    </li>
                                </ul>
                            </div>
                        </div>
                    </div> <!----> <!---->
                </div>
            </div>
        </div>
        <#--修改资料-->
        <div id="changeMsg" class="modal fade">
            <div class="modal-dialog" style="max-width: 600px">
                <div class="modal-content">
                    <div class="modal-body">
                        <button class="close" data-dismiss="modal">
                            <span>&times;</span>
                        </button>
                    </div>
                    <div class="modal-title">
                        <h4>修改资料</h4>
                    </div>
                    <div class="modal-body">
                        <form class="form-group" action="">
                            <div class="form-group form-inline">
                                <label class="input-group-text" for="">实名</label>
                                <input id="userRealName" class="form-control" type="text" placeholder="">
                            </div>
                            <div class="form-group form-inline">
                                <label class="input-group-text" for="">性别</label>
                                <select id="userGender" class="form-control">
                                    <option selected="selected">请选择性别</option>
                                    <option>男</option>
                                    <option>女</option>
                                </select>
                            </div>
                            <div  class="form-group form-inline">
                                <label class="input-group-text" for="">出生日期</label>
                                <input id="userBirth" class="form-control" type="date" />
                            </div>
                            <div class="form-group form-inline">
                                <label class="input-group-text" for="">地区</label>
                                <div data-toggle="distpicker">
                                    <select id="area_province" class="form-control"></select>
                                    <select id="area_city" class="form-control"></select>
                                    <select id="area_country" class="form-control"></select>
                                </div>
                            </div>
                            <div class="form-group form-inline">
                                <label class="input-group-text" for="">行业</label>
                                <select id="userTrade" class="form-control">
                                    <option selected="selected">请选择行业</option>
                                    <option>电子·微电子</option>
                                    <option>通信(设备·运营·增值服务)</option>
                                    <option>批发·零售</option>
                                    <option>贸易·进出口</option>
                                    <option>电子·微电子</option>
                                    <option>广告·会展·公关</option>
                                    <option>电子·微电子</option>
                                    <option>专业服务(咨询·财会·法律等)</option>
                                    <option>房地产开发·建筑与工程</option>
                                    <option>娱乐·运动·休闲</option>
                                </select>
                            </div>
                            <div class="form-group form-inline">
                                <label class="input-group-text" class="input-group-text" for="">职位</label>
                                <input id="userPosition" class="form-control" type="text" placeholder="">
                            </div>
                            <div class="form-group form-inline">
                                <label class="input-group-text" for="">简介</label>
                                <textarea id="userDescription" class="form-control" style="min-width: 350px" rows="3"></textarea>
                            </div>
                            <div class="text-right">
                                <button id="btn_ok" class="btn btn-primary" type="submit">确认</button>
                                <button id="btn_cancelL" class="btn btn-danger" data-dismiss="modal">取消</button>
                            </div>
                        </form>
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
    <script src="/static/js/userMsg.js"  crossorigin="anonymous"></script>
    <script src="/static/js/time.js"  crossorigin="anonymous"></script>
    <#--区域插件-->
    <script src="/static/areaJs/distpicker.data.js"></script>
    <script src="/static/areaJs/distpicker.js"></script>
    <script src="/static/areaJs/main.js"></script>

</body>
</html>