package com.jiang.entity;

import lombok.Data;

@Data
public class CommonResult {

    private int code;
    private String message;
    private Object data;
    private boolean status;

    protected CommonResult() {

    }

    protected CommonResult(int code,String message, Object data, boolean status) {
        this.code = code;
        this.message = message;
        this.data = data;
        this.status = status;
    }


    public static CommonResult success(String message,Object data) {
        return new CommonResult( 200,message, data, true);
    }


    public static CommonResult failed(String message,Object data) {
        return new CommonResult(500,message, data, false);
    }
}
