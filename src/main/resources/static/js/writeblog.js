/*初始化*/
$(function () {
    initSimditor();
    initSelect()
})
/*选项初始化*/
function initSelect(){
    $.get(truePath+"/article/selectSort",function (data) {
        for (var i=0;i<data.data.articleSort.length;i++){
            $("#selType").append("<option value='"+data.data.articleSort[i].sortArticleId+"'>"+data.data.articleSort[i].sortArticleName+"</option>");
        }
        for (var i=0;i<data.data.blogSort.length;i++){
            $("#radChl").append("<option value='"+data.data.blogSort[i].sortBlogId+"'>"+data.data.blogSort[i].sortBlogName+"</option>");
        }
    })
}
/*提交文章*/
$(function () {
    $("#btnPublish").click(function () {
        $.ajax({
            type:"POST",
            url:"article/new/submit",
            data: {articleName:$("#txtTitle").val(), articleTime:(new Date()).toDateString(),
                sortArticleId:$("#selType").val(),sortBolgId:$("#radChl").val(),articleContent:$("#editor").val()},
            dataType: "json",
            success: function(data){

                window.location.reload();
            }
        })
    })
})