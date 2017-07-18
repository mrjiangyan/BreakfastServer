package com.beyondh.breakfast.model.common;

/**
 * Created by jliang on 7/17/2017.
 */
public enum  ApiResponseCode{
    Success(0),
    IllegalArgumentException(1000),
    PMSException(2000),

    OtherException(8000),
    InnerError(9000);
    private ApiResponseCode(int value) {
        this.value = value;
    }

    private int value;
    public int getValue() {
        return value;
    }
}



