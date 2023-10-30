package com.timegoesby.bbscommon.constant;

import lombok.Data;

@Data
public class R<T> {

    private int code;

    private String message;

    private T data;

    public static <T> R<T> success(){
        return new R<>();
    }

    public static <T> R<T> success(T data){
        return new R<>(data);
    }

    public static <T> R<T> fail(String message){
        return new R<T>(CodeEnums.FAIL.getCode(),message);
    }

    public R(){
        this.code = CodeEnums.SUCCESS.getCode();
        this.message = CodeEnums.SUCCESS.getMessage();
    }

    public R(CodeEnums codeEnums){
        this.code = codeEnums.getCode();
        this.message = codeEnums.getMessage();
    }

    public R(int code,String msg){
        this.code = code;
        this.message = msg;
    }

    public R(T data){
        this.data = data;
        this.code = CodeEnums.SUCCESS.getCode();
        this.message = CodeEnums.SUCCESS.getMessage();
    }

    public R(T data,String msg){
        this.data = data;
        this.code = CodeEnums.SUCCESS.getCode();
        this.message = msg;
    }

}
