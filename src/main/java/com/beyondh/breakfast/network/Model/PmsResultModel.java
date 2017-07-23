package com.beyondh.breakfast.network.Model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by jliang on 7/20/2017.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class PmsResultModel<T> {

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

    public String getFullMessage() {
        return fullMessage;
    }

    public void setFullMessage(String fullMessage) {
        this.fullMessage = fullMessage;
    }

    public T getContent() {
        return content;
    }

    public void setContent(T content) {
        this.content = content;
    }

    @JsonProperty("Code")
    int code;

    @JsonProperty("Message")
    String message;

    @JsonProperty("FullMessage")
    String fullMessage;

    @JsonProperty("Content")
    T content;
}
