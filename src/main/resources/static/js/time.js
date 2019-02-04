// 对Date的扩展，将 Date 转化为指定格式的String
// 月(M)、日(d)、小时(H)、分(m)、秒(s)、季度(q) 可以用 1-2 个占位符，
// 年(y)可以用 1-4 个占位符，毫秒(S)只能用 1 个占位符(是 1-3 位的数字)
// 例子：
// (new Date()).Format("yyyy-MM-dd HH:mm:ss.S") ==> 2006-07-02 08:09:04.423
// (new Date()).Format("yyyy-M-d h:m:s.S")      ==> 2006-7-2 8:9:4.18
Date.prototype.Format = function(fmt)
{ //author: meizz
    var o = {
        "M+" : this.getMonth()+1,                 //月份
        "d+" : this.getDate(),                    //日
        "H+" : this.getHours(),                   //小时
        "m+" : this.getMinutes(),                 //分
        "s+" : this.getSeconds(),                 //秒
        "q+" : Math.floor((this.getMonth()+3)/3), //季度
        "S"  : this.getMilliseconds()             //毫秒
    };
    if(/(y+)/.test(fmt))
        fmt=fmt.replace(RegExp.$1, (this.getFullYear()+"").substr(4 - RegExp.$1.length));
    for(var k in o)
        if(new RegExp("("+ k +")").test(fmt))
            fmt = fmt.replace(RegExp.$1, (RegExp.$1.length==1) ? (o[k]) : (("00"+ o[k]).substr((""+ o[k]).length)));
    return fmt;
}

/**
 * 日期计较
 * timeStr1,timeStr2格式 yyyy-MM-dd HH:mm:ss
 * */
var isBigger = function(timeStr1,timeStr2){
    if(timeStr1==null||timeStr2==null) return null;
    var date1 = createDate(timeStr1);
    var date2 = createDate(timeStr2);
    if(date1 == null || date2 == null ) return null;
    if(date1.getTime() > date2.getTime() ){
        return 1;
    }else{
        return 0;
    }
}


/**
 * 初始化date
 * time格式为 yyyy-MM-dd HH:mm:ss
 * */
var createDate = function(time){
    if(time==null) return null;
    var yyyy = time.substring(0,4);
    var mth = time.substring(5,7);
    var dd = time.substring(8,10);
    var hh = time.substring(11,13);
    var mm = time.substring(14,16);
    var ss = time.substring(17,19);
    return new Date(yyyy,mth,dd,hh,mm,ss);
}
