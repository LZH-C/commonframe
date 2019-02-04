        <div class="col-sm-1 col-md-1 col-lg-1 col-xl-1">
            <a href="JavaScript:reLoading('/index');"><img id="logo" src="/static/img/logo.jpg"></a>
        </div>
            <div class="col-sm-5 col-md-5 col-lg-5 col-xl-5">
                <nav id="navTop" class="navbar navbar-expand-sm ">
                    <ul class="navbar-nav">
                        <li class="nav-item">
                            <a class="nav-link" href="JavaScript:reLoading('/index');" >首页</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="JavaScript:reLoading('/blog/'+sessionStorage.getItem('userName'));" data-toggle="modal" data-target="#login">我的博客</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link nav" href="#" data-toggle="modal" data-target="#login">个人日记</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="#" data-toggle="modal" data-target="#login">留言板</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="#">关于</a>
                        </li>
                    </ul>
                </nav>
            </div>
            <div id="nav" class="col-sm-6 col-md-6 col-lg-6 col-xl-6">
                <form class="form-inline float-xl-left">
                    <input id="search" class="form-control" type="text" placeholder="搜索">
                    <button class="btn btn-dark" type="button" onclick="searchAticle()">搜索</button>
                </form>
                <nav class="navbar navbar-expand-sm float-xl-right">
                    <ul class="navbar-nav">
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