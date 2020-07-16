package cn.wx.mzpro.wxentrance.util;

import java.io.Serializable;

/**
 * 封装公共返回包装类
 *
 * @param <T>
 */
public class Result<T> implements Serializable {
    private static final long serialVersionUID = -2218910418012718595L;
    private int code;
    private String message;
    private T data;

    private static final int SUCCESS_CODE = 200;// 成功
    private static final int FAIL_CODE = 400;//失败

    public Result(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public Result(int code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public static <T> Result<T> info(String message) {
        return new Result<T>(SUCCESS_CODE, message);
    }

    public static <T> Result<T> info(T data) {
        return new Result<T>(SUCCESS_CODE, "success", data);
    }

    public static <T> Result<T> info(String message, T data) {
        return new Result<T>(SUCCESS_CODE, message, data);
    }

    public static <T> Result<T> fail(String message, T data) {
        return new Result<T>(FAIL_CODE, message, data);
    }

    public static <T> Result<T> fail(String message) {
        return new Result<T>(FAIL_CODE, message);
    }

    public static <T> Result<T> fail(int code, String message) {
        return new Result<T>(code, message);
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
