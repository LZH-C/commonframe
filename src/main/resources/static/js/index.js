/*初始化*/
$(function () {
    initListArticle(0,5);
})


/*展示列表*/
function initListArticle(begin,end) {
    if (trueHref.indexOf("?keyword=")>=0&&(trueHref.indexOf("?keyword=")+9)<trueHref.length){
        $.ajax({
            type:"GET",
            url:truePath+"/article/list/"+trueHref.substring(trueHref.indexOf("?keyword=")+9,trueHref.length),
            dataType: "json",
            success: function(data){
                showListArticle(data.data);
            }
        })
    }else{
        $.ajax({
            type:"GET",
            url:truePath+"/article/list/"+begin+"/"+end,
            dataType: "json",
            success: function(data){
                showListArticle(data.data);
            }
        })
    }
}

/*展开文章列表*/
function showListArticle(data){
    $("ul.pagination").append("<li class=\"page-item\" id=\"toBegin\"><a class=\"page-link\" href=\"#\">&laquo;</a></li>");
    if (Math.ceil(data[0].articleNum/5)>3){
        $("ul.pagination").append("<li class=\"page-item\"><a class=\"page-link\" href=\"#\">1</a></li>\n" +
            "                    <li class=\"page-item\"><a class=\"page-link\" href=\"#\">2</a></li>\n" +
            "                    <li class=\"page-item\"><a class=\"page-link\" href=\"#\">3</a></li>\n" +
            "                    <li class=\"page-item\"><a class=\"page-link\" href=\"#\">...</a></li>")
       }else if(Math.ceil(data[0].articleNum/5)==3){
        $("ul.pagination").append("<li class=\"page-item\"><a class=\"page-link\" href=\"#\">1</a></li>\n" +
            "                    <li class=\"page-item\"><a class=\"page-link\" href=\"#\">2</a></li>\n" +
            "                    <li class=\"page-item\"><a class=\"page-link\" href=\"#\">3</a></li>")
    } else {
        for (var i = 0;i<Math.ceil(data[0].articleNum/5);i++) {
            $("ul.pagination").append("<li class=\"page-item\"><a class=\"page-link\" href=\"#\">"+(i+1)+"</a></li>")
        }
    }
    $("ul.pagination").append("<li class=\"page-item\" id=\"toEnd\"><a class=\"page-link\" href=\"#\">&raquo;</a></li>");

    $("#feedlist_id").html("");
    $.each(data,function (i,item) {
        $("#feedlist_id").append("<li class=\"clearfix\" data-type=\"blog\" data-id=\'"+item.articleName+"\' shown-time=\'"+item.articleTime+"\'>\n" +
            "        <div class=\"list_con\">\n" +
            "        <div class=\"title\">\n" +
            "        <h2>\n" +
            "        <a href=\"JavaScript:reLoading('/"+item.userName+"/article/details/"+item.articleId+"')\" target=\"_blank\" >\n" +
            "        "+item.articleName+"\n" +
            "</a>\n" +
            "    </h2>\n" +
            "    </div>\n" +
            "    <div class=\"summary oneline\">\n" +$(item.articleContent).text()+
            "        </div>\n" +
            "        <dl class=\"list_userbar\">\n " +
            "\n" +
            "        <dt>\n" +
            "        <a href=\'"+truePath+"/blog/"+item.userName+"\'  target=\"_blank\" class=\"user_img\">\n" +
            "        <img src=\"/static/img/index.jpg\" alt=\"\" title=\"\">\n" +
            "        </a>\n" +
            "        </dt>\n" +
            "        <dd class=\"name\">\n" +
            "        <a href=\'"+truePath+"/blog/"+item.userName+"\' target=\"_blank\">\n" +
            "        "+item.userName+"</a>\n" +
            "        </dd>\n" +
            "        <div class=\"interval\"></div>\n" +
            "        <dd class=\"tag\">\n" +
            "        <a href=\"/nav/iot\" target=\"_blank\">\n" +
            "        "+item.sortBlogName+"</a>\n" +
            "        </dd>\n" +
            "        <div class=\"interval\"></div>\n" +
            "        <dd class=\"time\">\n" +
            "        01月14日                    </dd>\n" +
            "    <div class=\"interactive floatR\">\n" +
            "        <!--阅读 begin-->\n" +
            "    <dd class=\"read_num\">\n" +
            "        <a href=\"JavaScript:reLoading('/"+item.userName+"/article/details/"+item.articleId+"')\" >\n" +
            "        <span class=\"text\">阅读数</span>\n" +
            "        <span class=\"num\">"+item.articleClick+"</span>\n" +
            "        </a>\n" +
            "        </dd>\n" +
            "        <div class=\"interval\"></div>\n" +
            "        <!--阅读 end-->\n" +
            "        <!--新增评论数+阅读 begin-->\n" +
            "        <dd class=\"common_num \">\n" +
            "        <a href=\"JavaScript:reLoading('/"+item.userName+"/article/details/"+item.articleId+"')\" target=\"_blank\" data-track-click=\"\">\n" +
            "        <span class=\"text\">评论数 </span>\n" +
            "        <span class=\"num\">"+item.commentNum+"</span>\n" +
            "        </a>\n" +
            "        </dd>\n" +
            "        <!--新增评论数+阅读 end-->\n" +
            "        </div>\n" +
            "        </dl>\n" +
            "        </div>\n" +
            "        </li>")
    })
}

/*分页按钮点击事件*/
$(function () {
    
})

