package com.beyondh.breakfast.model.common;

import java.io.Serializable;

/**
 * Created by jliang on 7/17/2017.
 */
public class ResultModel<T>  implements Serializable{
    public ResultModel() {
    }

    public ResultModel(ResultCode code, String message) {
        this.code = code;
        this.message = message;
    }

    public ResultModel(ResultCode code, String message, T content) {
        this.code = code;
        this.message = message;
        this.content = content;
    }

    public ResultModel(T content) {
        this.code = ResultCode.Success;
        this.content=content;
    }

    private ResultCode code;
    private String message;
    private T content;

    public ResultCode getCode() {
        return code;
    }

    public void setCode(ResultCode code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getContent() {
        return content;
    }

    public void setContent(T content) {
        this.content = content;
    }
}


