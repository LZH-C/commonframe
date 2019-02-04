<!doctype html>
<html lang="en">
<head>
    <link rel="shortcut icon" href="#" />
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="/static/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <link href="https://cdn.bootcss.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet">
    <link rel="stylesheet" href="/static/css/common.css">
    <title>Hello, world!</title>
</head>
<body>

<div class="navbar navbar-fixed-top">
    <div class="navbar-inner">
        <div class="container">
            <!--标题，字体稍微大点-->
            <a class="brand" href="#">larger5</a>
            <!--导航条具有响应式功能，主要是在屏幕较小的设备也能用-->
            <div class="nav-collapse collapse">
                <!--导航标签，H5就有了-->
                <ul class="nav">
                    <li >
                        <a href="#"><i class="icon-home"></i>&nbsp;主页</a>
                    </li>
                    <li >
                        <a href="#"><i class="icon-pencil"></i>&nbsp;写博文</a>
                    </li>
                    <li>
                        <a href="#"><i class="icon-book"></i>&nbsp;分类管理</a>
                    </li>
                    <li >
                        <a href="#"><i class="icon-user"></i>&nbsp;个人中心</a>
                    </li>
                </ul>
            </div>
            <!--导航条内的表单，居右-->
            <form name="myForm" class="navbar-form pull-right" method="post" action="">
                <input class="span2" id="s_title" name="s_title" type="text" style="margin-top:5px;height:30px;" placeholder="文章标题">
                <button type="submit" class="btn" onkeydown="if(event.keyCode==13) myForm.submit()"><i class="icon-search"></i>&nbsp;搜索</button>
            </form>
        </div>
    </div>
</div>
        <div class="container">
            <!--流式，按百分比分列-->
            <div class="row-fluid">
                <div class="span9">
                    <!--这里的内容经常会变化-->
                    <div class="data_list">
                        <div class="data_list_title">
                            <img src="images/list_icon.png" /> 最新资讯
                        </div>
                    </div>
                </div>
                <div class="span3">
                    <div class="data_list">
                        <div class="data_list_title">
                            <img src="images/user_icon.png" /> 个人中心
                        </div>
                    </div>

                    <div class="data_list">
                        <div class="data_list_title">
                            <img src="images/byType_icon.png" /> 按类别
                        </div>
                    </div>

                    <div class="data_list">
                        <div class="data_list_title">
                            <img src="images/byDate_icon.png" /> 按日期
                        </div>
                    </div>
                </div>
            </div>
        </div>

</body>
</html>