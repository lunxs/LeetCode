package com.lunx.glob.model;

import java.io.Serializable;

public class HttpResult<T> implements Serializable {
    private static final long serialVersionUID = 2564381169124812859L;

    private int code;

    private String message;

    private T data;

    public HttpResult() {
        this.code = 200;
        this.message = "SUCCESS";
    }

    public int getCode() {
        return code;
    }

    public HttpResult setCode(int code) {
        this.code = code;
        return this;
    }

    public String getMessage() {
        return message;
    }

    public HttpResult setMessage(String message) {
        this.message = message;
        return this;
    }

    public T getData() {
        return data;
    }

    public HttpResult setData(T data) {
        this.data = data;
        return this;
    }

    @Override
    public String toString() {
        return "HttpResult{" +
                "code=" + code +
                ", message='" + message + '\'' +
                ", data=" + data +
                '}';
    }
}
