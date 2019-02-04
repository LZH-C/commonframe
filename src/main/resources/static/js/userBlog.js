$(function () {
    initListArticle();
    initLeftWall(getPathValue1("/blog/"));
})

function initListArticle(){
    $.ajax({
        type: "GET",
        url: truePath + "/article/list?userName="+getPathValue1("/blog/") ,
        dataType: "json",
        success: function (data) {
            $.each(data.data,function (i,item) {
                $("#asideProfile div.data-info2").append("<div class=\"article-item-box csdn-tracking-statistics\" data-articleid=\'"+item.articleId+"\' style=\"border-bottom: 1px solid #e3e3e3;\">\n" +
                    "                            \n" +
                    "                            <h4 class=\"\">\n" +
                    "                                <a href=\"JavaScript:reLoading('/"+item.articleName+"/article/details/"+item.articleId+"')\" target=\"_blank\">\n" +
                    "        <span class=\"article-type type-1\">\n" + item.sortArticleName.substring(0,1)+" </span>\n" +item.articleName +" </a>\n" +
                    "                            </h4>\n" +
                    "                            <p class=\"content\">\n" +
                    "                                <a href=\"JavaScript:reLoading('/"+item.articleName+"/article/details/"+item.articleId+"')\" target=\"_blank\">\n" +
                    "                                 "+$(item.articleContent).text().substring(0,150)+".....</a>\n" +
                    "                            </p>\n" +
                    "                            <div class=\"info-box d-flex align-content-center\">\n" +
                    "                                <p>\n" +
                    "                                    <span class=\"date\">"+new Date(item.articleTime).Format("yyyy-MM-dd")+"</span>\n" +
                    "                                </p>\n" +
                    "                                <p class=\"point\"></p>\n" +
                    "                                <p>\n" +
                    "                                    <span class=\"read-num\">阅读数 <span class=\"num\">"+item.articleClick+"</span> </span>\n" +
                    "                                </p>\n" +
                    "                                <p class=\"point\"></p>\n" +
                    "                                <p>\n" +
                    "                                    <span class=\"read-num\">评论数 <span class=\"num\">"+item.commentNum+"</span> </span>\n" +
                    "                                </p>\n" +
                    "                            </div>\n" +
                    "                        </div>")
            });
        }
    })

}