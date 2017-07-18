package com.beyondh.breakfast.model.common;

/**
 * Created by jliang on 7/19/2017.
 */
public class ApiResponse<T> {

    String message;
    T data;
    int code;


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

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public boolean isOk() {
        return code==0;
    }

}
