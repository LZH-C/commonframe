/*登录状态*/
var loginStatus=false;
/*真实路径*/
var truePath="http://"+window.location.host;
var trueHref=window.location.href;
/*页面跳转*/
function reLoading(path){
    window.location.href=truePath+path;
}
/*判断登录状态*/
$(function () {
    isLogin();
    if (loginStatus==true&&sessionStorage.getItem('userName')!=null){
        $("#login_1").css('display','none');
        $("#register_1").css('display','none');
        $("#user").css('display','inline');
        $("#logOut").css('display','inline');
        $("#user a").html(sessionStorage.getItem('userName'));
        $("#navTop>ul li a").removeAttr('data-toggle').removeAttr('data-target');
    }
})
function isLogin(){
    $.ajax({
        type:"GET",
        url:truePath+"/user/isAuthenticated",
        dataType: "json",
        async: false,
        success: function(data){
            loginStatus=data;
        }
    })
}
/*注册*/
$(function () {
    $("#btn_register").click(function () {
        $.ajax({
            type:"POST",
            url:truePath+"/user/register",
            data: {userName:$("#ruserName").val(), password:$("#rpassword1").val(), email:$("#remail").val()/*,userRegisterTime:(new Date()).toDateString()*/},
            dataType: "json",
            success: function(data){

            }
        })
    })
})

/*登录*/
$(function () {
    $("#btn_login").on("click",(function () {
        /*ajax默认请求异步操作*/
        $.ajax({
            type:"POST",
            url:truePath+"/user/login",
            data: {userName:$("#userName").val(), password:$("#password").val()},
            dataType: "json",
            async: false,
            success: function(data){
                if (data.code ==200 ) {
                    sessionStorage.setItem('userName',data.data.userName);
                    alert("登录成功");
                    window.location.reload();
                }
                if (data.code ==1004 ) {
                    alert(data.msg);
                    $("#login_1 a").click();
                }
            }
        })
    }));
})
/*登出*/
$(function () {
    $("#logOut a").click(function () {
        $.get(truePath+"/user/logout",function (data) {
            sessionStorage.removeItem('userName');
            window.location.href='index';
        })
    })
})

/*富文本编辑配置*/
function initSimditor(){
    Simditor.locale = 'zh-CN';//设置中文
    var editor = new Simditor({
        textarea: $("#editor"),  //textarea的id
        placeholder: '',
        toolbar:  ['title', 'bold', 'italic', 'underline', 'strikethrough', 'fontScale', 'color', '|', 'ol', 'ul', 'blockquote', 'code', 'table', '|', 'link', 'image', 'hr', '|', 'indent', 'outdent', 'alignment'], //工具条都包含哪些内容
        pasteImage: true,//允许粘贴图片
        defaultImage: '/static/smiditor/images/image.png',//编辑器插入的默认图片，此处可以删除
        upload : {
            url : '/article/smiditor/uploadSimditorImg', //文件上传的接口地址
            params: null, //键值对,指定文件上传接口的额外参数,上传的时候随文件一起提交
            fileKey:'file', //服务器端获取文件数据的参数名
            connectionCount: 3,
            leaveConfirm: '正在上传文件'
        }
    });


}

/*获取url某个位置的值*/
function getPathValue1(str){
    var begin=window.location.pathname.indexOf(str)+str.length;
    var len=window.location.pathname.length-begin;
    return window.location.pathname.substr(begin, len);
}
function getPathValue2(str1,str2){
    var begin=trueHref.indexOf(str1)+str1.length;
    var len=trueHref.indexOf(str2)-begin;
    return trueHref.substr(begin,len);
}

/*搜索新文章*/
function searchAticle() {
    window.location.href=truePath+"/index?keyword="+$("#search").val();
}
$(function () {
    $("#search").keydown(function (event) {
        if (event.keyCode == 13) {
            $("#search").blur();
            searchAticle();
        }
    })
})

/*初始化左边框墙的信息*/
function initLeftWall(userName) {
    $.ajax({
        type:"GET",
        url:truePath+"/user/getUserRelation/"+userName,
        dataType: "json",
        success: function(data){
            $("#uid").html(userName);
            $("#original").html(data.data.original).parents("dl").attr("title",data.data.original);
            $("#attention").html(data.data.attention).parents("dl").attr("title",data.data.attention);
            $("#click").html(data.data.click).parents("dl").attr("title",data.data.click);
            $("#commentNum").html(data.data.commentNum).parents("dl").attr("title",data.data.commentNum);
            $("#liking").html(data.data.liking).parents("dl").attr("title",data.data.liking);
        }
    })
}
