<div class="col-xl-3">
    <img id="logo" src="/static/img/logo.jpg">
</div>
            <div class="col-xl-3">
            </div>
            <div id="nav" class="col-xl-6">
                <nav class="navbar navbar-expand-sm ">
                    <ul class="navbar-nav">
                        <li class="nav-item">
                            <a class="nav-link" href="JavaScript:reLoading('/index');">首页</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="JavaScript:reLoading('/blog/'+sessionStorage.getItem('userName'));">我的博客</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link nav" href="JavaScript:reLoading('/writeblog')">写博客</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link nav" href="#">我的草稿</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="#">留言板</a>
                        </li>
                        <li class="nav-item" id="login_1">
                            <a class="nav-link" href="#" data-toggle="modal" data-target="#login">登录</a>
                        </li>
                        <li class="nav-item" id="register_1">
                            <a class="nav-link" href="#" data-toggle="modal" data-target="#register">注册</a>
                        </li>
                        <li class="nav-item" style="display: none" id="user">
                            <a class="nav-link" href="JavaScript:reLoading('/userMsg');" >用户名</a>
                        </li>
                        <li class="nav-item" style="display: none" id="logOut">
                            <a class="nav-link" href="#" >退出</a>
                        </li>
                    </ul>
                </nav>
            </div>