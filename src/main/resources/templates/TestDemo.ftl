<!doctype html>
<html lang="en">
<head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="/static/css/bootstrap.min.css"  crossorigin="anonymous">
    <link rel="stylesheet" href="/static/css/common.css?v=1111111">
    <title>Hello, world!</title>
</head>
<body>

<!-- Optional JavaScript -->
<!-- jQuery first, then Popper.js, then Bootstrap JS -->
<script src="/static/js/jquery-3.3.1.js"  crossorigin="anonymous"></script>
<script src="/static/js/popper.min.js"  crossorigin="anonymous"></script>
<script src="/static/js/bootstrap.min.js"  crossorigin="anonymous"></script>

<div class="container">
    <div class="container-fluid">
        <div class="row">
            <div class="col-xl-3">
                <img id="logo" src="/static/img/logo.jpg">
            </div>
            <div class="col-xl-4">
            </div>
            <div id="nav" class="col-sm-9 col-md-9 col-lg-8 col-xl-5">
                <nav class="navbar navbar-expand-sm ">
                    <ul class="navbar-nav">
                        <li class="nav-item">
                            <a class="nav-link" href="#">首页</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="#">关于</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link nav" href="#">个人日记</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="#">留言板</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="#" data-toggle="modal" data-target="#login">登录</a>
                        </li>
                        <#--<li class="nav-item">
                            <a class="nav-link" href="#" data-toggle="modal" data-target="#register">注册</a>
                        </li>-->
                    </ul>
                </nav>
            </div>
        </div>

        <div class="row">
            <div class="col-sm-3 col-md-6 col-lg-4 col-xl-12">
                <img src="/static/img/index.png" style="width: 100%;height: auto">
            </div>
        </div>

        <div class="row">
            <div class="col-sm-3 col-md-6 col-lg-4 col-xl-2">
                <p>文章列表:</p>
            </div>
            <div class="col-sm-9 col-md-6 col-lg-8 col-xl-5">

            </div>
            <div class="col-xl-5" >
                <form class="form-inline">
                    <input id="search" class="form-control" type="text" placeholder="搜索">
                    <button class="btn btn-dark" type="button">搜索</button>
                </form>
            </div>

        </div>

        <div class="row">
            <table class="table">
                <thead>
                <tr>
                    <th>文章名称</th>
                    <th width="150px">发布时间</th>
                </tr>
                </thead>
                <tbody>
                <tr>
                    <td><a href="#"><i>John</i></a></td>
                    <td>Doe</td>

                </tr>
                <tr>
                    <td>Mary</td>
                    <td>Moe</td>

                </tr>
                <tr>
                    <td>July</td>
                    <td>Dooley</td>

                </tr>
                </tbody>
            </table>
        </div>

        <div  class="row">
            <div id="article">
                <ul class="pagination">
                    <li class="page-item"><a class="page-link" href="#">&laquo;</a></li>
                    <li class="page-item"><a class="page-link" href="#">1</a></li>
                    <li class="page-item"><a class="page-link" href="#">2</a></li>
                    <li class="page-item"><a class="page-link" href="#">3</a></li>
                    <li class="page-item"><a class="page-link" href="#">...</a></li>
                    <li class="page-item"><a class="page-link" href="#">&raquo;</a></li>
                </ul>
            </div>
        </div>

        <!-- 注册窗口 -->
        <div id="register" class="modal fade" tabindex="-1">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-body">
                        <button class="close" data-dismiss="modal">
                            <span>&times;</span>
                        </button>
                    </div>
                    <div class="modal-title">
                        <h1 class="text-center">注册</h1>
                    </div>
                    <div class="modal-body">
                        <form class="form-group" action="">
                            <div class="form-group">
                                <label for="">用户名</label>
                                <input class="form-control" type="text" placeholder="6-15位字母或数字">
                            </div>
                            <div class="form-group">
                                <label for="">密码</label>
                                <input class="form-control" type="password" placeholder="至少6位字母或数字">
                            </div>
                            <div class="form-group">
                                <label for="">再次输入密码</label>
                                <input class="form-control" type="password" placeholder="至少6位字母或数字">
                            </div>
                            <div class="form-group">
                                <label for="">邮箱</label>
                                <input class="form-control" type="email" placeholder="例如:123@123.com">
                            </div>
                            <div class="text-right">
                                <button class="btn btn-primary" type="submit">提交</button>
                                <button class="btn btn-danger" data-dismiss="modal">取消</button>
                            </div>
                            <a href="" data-toggle="modal" data-dismiss="modal" data-target="#login">已有账号？点我登录</a>
                        </form>
                    </div>
                </div>
            </div>
        </div>
        <!-- 登录窗口 -->
        <div id="login" class="modal fade">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-body">
                        <button class="close" data-dismiss="modal">
                            <span>&times;</span>
                        </button>
                    </div>
                    <div class="modal-title">
                        <h1 class="text-center">登录</h1>
                    </div>
                    <div class="modal-body">
                        <form class="form-group" action="">
                            <div class="form-group">
                                <label for="">用户名</label>
                                <input class="form-control" type="text" placeholder="">
                            </div>
                            <div class="form-group">
                                <label for="">密码</label>
                                <input class="form-control" type="password" placeholder="">
                            </div>
                            <div class="text-right">
                                <button class="btn btn-primary" type="submit">登录</button>
                                <button class="btn btn-danger" data-dismiss="modal">取消</button>
                            </div>
                            <a href="" data-toggle="modal" data-dismiss="modal" data-target="#register">还没有账号？点我注册</a>
                        </form>
                    </div>
                </div>
            </div>
        </div>

        <#--<div class="row">
            <div class="col-sm-3 col-md-6 col-lg-4 col-xl-2">
             预留行
            </div>
        </div>-->
    </div>

</div>

</body>
</html>