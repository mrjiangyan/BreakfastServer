package com.beyondh.breakfast.utils;

import com.beyondh.breakfast.model.common.ApiResponse;
import com.beyondh.breakfast.model.common.ApiResponseCode;
import org.springframework.web.client.RestClientException;

/**
 * Created by jliang on 7/17/2017.
 */
public class ExceptionUtils {

    public static <T> ApiResponse<T> HandleException(Exception exception, ApiResponse<T> returnResult) {
        try {
            if (exception instanceof IllegalArgumentException) {
                returnResult.setCode(ApiResponseCode.IllegalArgumentException.getValue());
            } else if (exception instanceof RestClientException) //目前只访问PMS，暂时这样设置
            {
                returnResult.setCode(ApiResponseCode.PMSException.getValue());
            } else {
                returnResult.setCode(ApiResponseCode.OtherException.getValue());
            }
        } catch (Exception e) {
            returnResult.setCode(ApiResponseCode.InnerError.getValue());
        }

        returnResult.setMessage(exception.getMessage());
        return returnResult;
    }
}
