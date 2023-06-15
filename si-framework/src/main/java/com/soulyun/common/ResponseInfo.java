package com.soulyun.common;

public class ResponseInfo<T> {

    private Integer code;
    private String message;
    private T data;

    public ResponseInfo() {
    }

    public ResponseInfo(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public ResponseInfo(Integer code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    /**
     * 响应失败方法
     * @author fan
     * @date 2023/6/15 13:25
     * @param code 响应代码
     * @param message 相应信息
     * @return com.soulyun.common.ResponseInfo
     */
    public static <T> ResponseInfo<T> failed (Integer code, String message) {
        return new ResponseInfo<>(code, message);
    }

    /**
     * 响应成功
     * @author fan
     * @date 2023/6/15 13:26
     * @return com.soulyun.common.ResponseInfo
     */
    public static <T> ResponseInfo<T> success () {
        return new ResponseInfo<>(ResponseServiceEnum.SI_SUCCESS.getCode(), ResponseServiceEnum.SI_SUCCESS.getMessage());
    }

    /**
     * 相应成功（返回数据）
     * @author fan
     * @date 2023/6/15 13:26
     * @param data 返回数据
     * @return com.soulyun.common.ResponseInfo
     */
    public static <T> ResponseInfo<T> success (T data) {
        ResponseInfo<T> result = success();
        result.setData(data);
        return result;
    }
}
