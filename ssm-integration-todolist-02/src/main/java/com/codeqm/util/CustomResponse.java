package com.codeqm.util;

import lombok.Data;

/**
 * @since: 2025/6/9 15:58
 * @author: qm
 * @description:
 */
@Data
public class CustomResponse {
    private int code = 200;             //200成功状态码
    private boolean flag = true;        //返回状态
    private Object data;                //返回具体数据

    public static CustomResponse ok(Object data) {
        CustomResponse customResponse = new CustomResponse();
        customResponse.data = data;
        return customResponse;
    }

    public static CustomResponse fail(Object data) {
        CustomResponse customResponse = new CustomResponse();
        customResponse.code = 500;      //错误码
        customResponse.flag = false;    //错误状态
        customResponse.data = data;
        return customResponse;
    }
}
