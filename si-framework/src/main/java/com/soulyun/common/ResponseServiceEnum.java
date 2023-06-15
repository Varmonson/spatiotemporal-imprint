package com.soulyun.common;

public enum ResponseServiceEnum {

    SI_SUCCESS(200, "请求成功!"),
    SI_FAILED(400, "请求失败!"),
    SI_EXCEPTION(500, "服务器异常!"),
    ;

    private final Integer code;
    private final String message;

    ResponseServiceEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
