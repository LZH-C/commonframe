/*初始化*/
$(function () {
    initSimditor();
    initSelect();
    if (getPathValue2("change=","&articleId")=="true"){
        initChangeArticle(getPathValue3("&articleId="));
    }
})
/*选项初始化*/
function initSelect(){
    $.ajax({
        type:"GET",
        url:truePath+"/article/selectSort",
        dataType: "json",
        async:false,
        success: function(data){
            for (var i=0;i<data.data.articleSort.length;i++){
                $("#selType").append("<option value='"+data.data.articleSort[i].sortArticleId+"'>"+data.data.articleSort[i].sortArticleName+"</option>");
            }
            for (var i=0;i<data.data.blogSort.length;i++){
                $("#radChl").append("<option value='"+data.data.blogSort[i].sortBlogId+"'>"+data.data.blogSort[i].sortBlogName+"</option>");
            }
        }
    })
}
/*提交文章*/
$(function () {
    if (getPathValue2("change=","&articleId")=="true"){
        $("#btnPublish").val("修改文章");
        $("#btnPublish").on("click",function () {
            $.ajax({
                type: "POST",
                url: truePath + "/article/update/",
                data: {
                    articleId:getPathValue3("&articleId="),
                    articleName: $("#txtTitle").val(),
                    articleTime: (new Date()).toDateString(),
                    sortArticleId: $("#selType").val(),
                    sortBlogId: $("#radChl").val(),
                    articleContent: $("#editor").val()
                },
                dataType: "json",
                success: function (data) {
                    if (data.code==400){
                        alert("修改失败！");
                    }
                    if (data.code==1){
                        alert("修改成功！");
                        window.location.href=truePath+"/blog/"+userName;
                    }
                }
            })
        })
    }else {
        $("#btnPublish").on("click",function () {
            $.ajax({
                type: "POST",
                url: truePath + "/article/new/submit",
                data: {
                    articleName: $("#txtTitle").val(),
                    articleTime: (new Date()).toDateString(),
                    sortArticleId: $("#selType").val(),
                    sortBlogId: $("#radChl").val(),
                    articleContent: $("#editor").val()
                },
                dataType: "json",
                success: function (data) {
                    if (data.code==400){
                        alert("发布失败！");
                    }else {
                        alert("发布成功！");
                        window.location.href = truePath + "/blog/" + userName;
                    }

                }
            })
        })
    }
})

function initChangeArticle(articleId){
    $.ajax({
        type:"GET",
        url:truePath+"/article/details/"+articleId,
        dataType: "json",
        success: function(data){
            $("#selType").val(data.data.sortArticleId);
            $("#radChl").val(data.data.sortBlogId);
            $("#txtTitle").val(data.data.articleName);
            $("div.simditor-body").append(data.data.articleContent);
        }
    })
}