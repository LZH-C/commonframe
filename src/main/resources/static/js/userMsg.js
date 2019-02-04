/*初始化*/
$(function () {
    intiUserMsg();
})

/*头像图片的上传*/
$(function () {
    $("#changeImgHead").on("click",function () {
        $("#input_upload_driver").click();
    })
    $("#input_upload_driver").on("change",function () {
        preview(this,"imgHead");
        /*图片的上传*/
        // 创建
        var form_data = new FormData();
        // 获取文件
        var file_data = $("#input_upload_driver").prop("files")[0];
        // 把所以表单信息
        form_data.append("file", file_data);
        $.ajax({
            type: "POST",
            url: truePath+"/user/logo/change",
            dataType : "json",
            processData: false,  // 注意：让jQuery不要处理数据
            contentType: false,  // 注意：让jQuery不要设置contentType
            data: form_data,
            success:function (data) {
                alert(data);
            }
        })
    })
})

/*图片更新*/
function preview(file, container){
    //缩略图类定义
    var Picture  = function(file, container){
        var height = 0,
            width  = 0,
            ext    = '',
            size   = 0,
            name   = '',
            path   =  '';
        var self   = this;
        if(file){
            name = file.value;
            if(window.navigator.userAgent.indexOf("MSIE")>=1){
                file.select();
                path = document.selection.createRange().text;
            }else {
                if(file.files){
                    // path =  file.files.item(0).getAsDataURL(); // firefox7.0之后该方法弃用了，用下面那个
                    path = window.URL.createObjectURL(file.files[0]);
                }else{
                    path = file.value;
                }
            }
        }else{
            throw '无效的文件';
        }
        ext = name.substr(name.lastIndexOf("."), name.length);
        if(container.tagName.toLowerCase() != 'img'){
            throw '不是一个有效的图片容器';
            container.visibility = 'hidden';
        }
        container.src = path;
        container.alt = name;
        container.style.visibility = 'visible';
        height = container.height;
        width  = container.width;
        size   = container.fileSize;
        this.get = function(name){
            return self[name];
        };
        this.isValid = function(){
            if(allowExt.indexOf(self.ext) !== -1){
                throw '不允许上传该文件类型';
                return false;
            }
        }
    };

    try{
        var pic =  new Picture(file, document.getElementById('' + container));
    }catch(e){
        alert(e);
    }
};

/*用户资料的更新*/
$(function () {
    $("#btn_ok").on("click",function () {
        $.ajax({
            type:"POST",
            url:truePath+"/user/msg/update",
            dataType: "json",
            data:{userRealName:$("#userRealName").val(),
                userGender:$("#userGender").val(),
                userArea:$("#area_province").val()+"-"+$("#area_city").val()+"-"+$("#area_country").val(),
                userTrade:$("#userTrade").val(),
                userPosition:$("#userPosition").val(),
                userDescription:$("#userDescription").val(),
                userBirth:$("#userBirth").val().length==0?new Date(-1).toDateString():new Date($("#userBirth").val().replace(/-/g, '/')).toDateString()},
            success: function(data){
                intiUserMsg();
            }
        })
    })
})

function intiUserMsg() {
    $.ajax({
        type:"GET",
        url:truePath+"/user/msg",
        dataType: "json",
        success: function(data){
            /*初始化页面*/
            $("#imgHead").attr("src",data.data.userImageUrl);
            $("span.id_name").html("ID:"+(data.data.userName==null?" ":data.data.userName));
            $("#li-userRealName").html("实名："+(data.data.userRealName==null?" ":data.data.userRealName));
            $("#li-userGender").html("性别："+(data.data.userGender==null?" ":data.data.userGender));
            $("#li-userArea").html("地区："+(data.data.userArea==null?" ":data.data.userArea));
            $("#li-userTrade").html("行业："+(data.data.userTrade==null?" ":data.data.userTrade));
            $("#li-userPosition").html("职位："+(data.data.userPosition==null?" ":data.data.userPosition));
            $("#li-userDescription").html((data.data.userDescription==null?" ":data.data.userDescription));
            $("#li-userBirth").html("生日："+(data.data.userBirth==null?" ":new Date(data.data.userBirth).Format("yyyy-MM-dd")));
            /*初始化修改输入框*/
            $("#userRealName").val(data.data.userRealName);
            $("#userGender").val(data.data.userGender);
            $("#area_province").val(data.data.userArea==null?null:data.data.userArea.split("-")[0]);
            $("#area_province").change()
            $("#area_city").val(data.data.userArea==null?null:data.data.userArea.split("-")[1]);
            $("#area_province").change()
            $("#area_country").val(data.data.userArea==null?null:data.data.userArea.split("-")[2]);
            $("#userTrade").val(data.data.userTrade);
            $("#userPosition").val(data.data.userPosition);
            $("#userDescription").val(data.data.userDescription);
            if (data.data.userBirth!=null){
                $("#userBirth").val(new Date(data.data.userBirth).Format("yyyy-MM-dd"));
            }
        }
    })
}