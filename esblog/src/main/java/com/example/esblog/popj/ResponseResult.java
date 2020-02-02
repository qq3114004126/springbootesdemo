package com.example.esblog.popj;

public class ResponseResult {

    private String code;

    private String msg;

    private Object data;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public ResponseResult(String code, String msg, Object data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public static ResponseResult error(final String errorMessage) {
        return new ResponseResult("0",errorMessage,null);
    }

    public static ResponseResult success(final String message,final Object data) {
        return new ResponseResult("1",message,data);
    }
    public static ResponseResult success(){
        return ResponseResult.success(null,null);
    }

    public static ResponseResult success(final Object data){
        return ResponseResult.success(null,data);
    }

}
