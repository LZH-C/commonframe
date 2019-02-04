var articleId=window.location.href.substr(window.location.href.indexOf("details/")+8,window.location.href.length);
$(function () {
    initArticle(articleId);
    initComment();
    initLeftWall(getPathValue2(truePath+"/","/article/details/"));
})

$(function () {
    $("body").on("click",function(){
        if (document.activeElement.id=="comment_content") {
            $("#comment_detail").addClass("d-flex");
            $("#comment_content").css("height","150px");
        }
        if (document.activeElement.id!="comment_content"&&document.activeElement.id!="addArticleComment") {
            $("#comment_detail").removeClass("d-flex");
            $("#comment_content").css("height","auto");
        }
    })
})

/*初始化文章内容*/
function initArticle(articleId) {
    $.ajax({
        type:"GET",
        url:"/article/details/"+articleId,
        dataType: "json",
        success: function(data){
            if (sessionStorage.getItem('userName')==data.data.userName&&loginStatus){
                $("#userFunc").css("display","block");
            }
            $("#asideProfile div h3").html(data.data.articleName);
            $("#asideProfile span.time").html(format(data.data.articleTime));
            $("#asideProfile span.read-count").html("阅读数："+data.data.articleClick);
            $("#asideProfile div.data-info2").append(data.data.articleContent);
        }
    })
}
/*初始化评论*/
function initComment() {
    /*ajax默认请求异步操作*/
    $.ajax({
        type:"GET",
        url:truePath+"/article/comment/load/"+window.location.href.substr(window.location.href.indexOf("details/")+8,window.location.href.length),
        dataType: "json",
        async: false,
        success: function(data){
            $.each(data.data,function (i,item) {
                $("#commentList").prepend("<ul class=\"comment-list combox"+item.commentId+"\">" +
                    "<li class=\"comment-line-box d-flex\" data-commentid=\'"+item.commentId+"\' data-replyname=\'"+item.userName+"\'>\n" +
                    "                                            <a target=\"_blank\" href=\'"+truePath+"/blog/"+item.userName+"\'>\n" +
                    "                                                <img src=\'"+item.userImageUrl+"\' alt=\'"+item.userName+"\' class=\"avatar\">\n" +
                    "                                            </a>\n" +
                    "                                            <div class=\"right-box \">\n" +
                    "                                                <div class=\"info-box\">\n" +
                    "                                                    <a target=\"_blank\" href=\'"+truePath+"/blog/"+item.userName+"\'>\n" +
                    "                                                        <span class=\"name \">"+item.userName+"</span>\n" +
                    "                                                    </a>\n" +
                    "                                                    <span class=\"comment\">"+item.content+"</span>\n" +
                    "                                                    <span class=\"date\" title=\'"+item.commitTime+"\'>"+new Date(item.commitTime).Format("yyyy-MM-dd HH:mm:ss")+"</span>\n" +
                    "                                                    <span class=\"floor-num\">#"+(i+1)+"楼)</span>\n" +
                    "                                                    <span class=\"opt-box\">\n" +
                    "                                                        <a class=\"btn btn-link-blue btn-read-reply \"  data-type=\"readreply\">查看回复</a>\n" +
                    "                                                        <a class=\"btn btn-link-blue btn-report\" data-type=\"report\">举报</a>\n" +
                    "                                                        <a class=\"btn btn-link-blue btn-reply\" data-type=\"reply\">回复</a></span></div>\n" +
                    "                                            </div>\n" +
                    "                                        </li>" +
                    "</ul>\n"
                    )
                $.each(item.commentReplies,function (i,nitem) {
                    $(".combox"+item.commentId+".comment-list").append("                                        <li class=\"replay-box\" style=\"display: none;\">\n" +
                        "                                            <ul class=\"comment-list\">\n" +
                        "                                                <li class=\"comment-line-box d-flex\" data-commentid=\'"+item.commentId+"\' data-replyname=\'"+nitem.replyName+"\'>\n" +
                        "                                                    <a target=\"_blank\" href=\'"+truePath+"/blog/"+nitem.userName+"\'>\n" +
                        "                                                        <img src=\'"+nitem.userImageUrl+"\' alt=\'"+nitem.replyName+"\' class=\"avatar\">\n" +
                        "                                                    </a>\n" +
                        "                                                    <div class=\"right-box reply-box\">\n" +
                        "                                                        <div class=\"info-box\">\n" +
                        "                                                            <a target=\"_blank\" href=\'"+truePath+"/blog/"+nitem.userName+"\'>\n" +
                        "                                                                <span class=\"name mr-8\">"+nitem.replyName+"</span>\n" +
                        "                                                            </a>回复\n" +
                        "                                                            <span class=\"name\">"+nitem.beReplyName+"</span>\n" +
                        "                                                            <span class=\"comment\">"+nitem.commitContent+"</span>\n" +
                        "                                                            <span class=\"date\" title=\'"+nitem.commitTime+"\'>"+new Date(nitem.commitTime).Format("yyyy-MM-dd HH:mm:ss")+"</span>\n" +
                        "                                                            <span class=\"opt-box\">\n" +
                        "                                                                <a class=\"btn btn-link-blue btn-report\" data-type=\"report\">举报</a>\n" +
                        "                                                                <a class=\"btn btn-link-blue btn-reply\" data-type=\"reply\">回复</a>\n" +
                        "                                                            </span>\n" +
                        "                                                        </div>\n"
                    )
                })
                if (item.commentReplies.length==0){
                    $(".combox"+item.commentId+".comment-list a.btn-read-reply").css("display","none");
                }
            });
        }
    })
}

$(function () {
    $("span").on("click","a.btn-read-reply",function(){
        $(this).parents("li").nextAll().css("display","list-item");
        $(this).html("收起回复");
        $(this).addClass("open");
    })
    $("span").on("click","a.open",function(){
        $(this).parents("li").nextAll().css("display","none");
        $(this).html("查看回复");
        $(this).removeClass("open");
    })
    $("span").on("click","a.btn-reply",function(){
        var name=$(this).parents("div.info-box").children("a").children("span").text();
        $("#comment_content").val("[reply]"+name+"[/reply]\n").focus();
        $("#comment_replyId").val($(this).parents("li.comment-line-box").attr("data-commentid"));
        $("#comment_replyUserName").val(name);
    })
})

/*时间戳格式化*/
function format(shijianchuo) {
    var time = new Date(shijianchuo);
    var y = time.getFullYear();
    var m = time.getMonth()+1;
    var d = time.getDate();
    var h = time.getHours();
    var mm = time.getMinutes();
    var s = time.getSeconds();
    return y+'年'+add0(m)+'月'+add0(d)+'日'+add0(h)+':'+add0(mm)+':'+add0(s);
}
function add0(time) {
    return time<10?'0'+time:time;
}

/*提交评论*/
function addComment() {
    if ($("#comment_content").val().indexOf("[reply]")>=0&&$("#comment_content").val().indexOf("[/reply]")>=0){
        addCommentToUser();
    }else {
        addCommentToTopic();
    }
}
function addCommentToTopic() {
    /*ajax默认请求异步操作*/
    if (sessionStorage.getItem('userName')!=null&&loginStatus==true){
        $("#addArticleComment").removeAttr('data-toggle').removeAttr('data-target');
    }
    $.ajax({
        type:"POST",
        url:truePath+"/article/comment/topic/add",
        data: {topicId:getPathValue1("details/"), content:$("#comment_content").val(),
            commitTime:new Date().toDateString()},
        dataType: "json",
        async: false,
        success: function(data){
            $("#comment_content").val('');
            $("#comment_content").css("height","auto");
            $("#comment_detail").removeClass("d-flex");
        }
    })
}
function addCommentToUser() {
    /*ajax默认请求异步操作*/
    if (sessionStorage.getItem('userName')!=null&&loginStatus==true){
        $("#addArticleComment").removeAttr('data-toggle').removeAttr('data-target');
    }
    $.ajax({
        type:"POST",
        url:truePath+"/article/comment/2level/add",
        data: {replyId:$("#comment_replyId").val(),
            commitContent:$("#comment_content").val().substring($("#comment_content").val().indexOf("[/reply]")+9,$("#comment_content").val().length),
            beReplyName:$("#comment_replyUserName").val(),
            commitTime:new Date().toDateString()},
        dataType: "json",
        async: false,
        success: function(data){
            $("#comment_content").val('');
            $("#comment_content").css("height","auto");
            $("#comment_detail").removeClass("d-flex");
        }
    })
}

function changeArticle() {
    window.location.href=truePath+"/writeblog?change=true&articleId="+articleId;
}

function delArticle() {
    $.ajax({
        type:"GET",
        url:truePath+"/article/delArticle/"+articleId,
        dataType: "json",
        success: function(data){
            if (data.code==400){
                alert("删除失败！");
            }
            if (data.code==1){
                alert("删除成功！");
                window.location.href=truePath+"/blog/"+userName;
            }
        }
    })
}