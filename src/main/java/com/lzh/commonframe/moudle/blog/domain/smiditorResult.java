package com.lzh.commonframe.moudle.blog.domain;

public class smiditorResult {

    String file_path;

    Boolean success;

    String msg;

    public smiditorResult(String file_path,Boolean success,String msg){
        this.file_path=file_path;
        this.success=success;
        this.msg=msg;
    }

    public String getFile_path() {
        return file_path;
    }

    public void setFile_path(String file_path) {
        this.file_path = file_path;
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
