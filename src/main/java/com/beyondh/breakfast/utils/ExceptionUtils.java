package com.beyondh.breakfast.utils;

import com.beyondh.breakfast.model.common.ResultCode;
import com.beyondh.breakfast.model.common.ResultModel;
import org.springframework.web.client.RestClientException;

/**
 * Created by jliang on 7/17/2017.
 */
public class ExceptionUtils {

    public static <T> ResultModel<T> HandleException(Exception exception, ResultModel<T> returnResult) {
        try {
            if (exception instanceof IllegalArgumentException) {
                returnResult = new ResultModel<T>(ResultCode.IllegalArgumentException, exception.getMessage());
            } else if (exception instanceof RestClientException) //目前只访问PMS，暂时这样设置
            {
                returnResult = new ResultModel<T>(ResultCode.PMSException, exception.getMessage());
            } else {
                returnResult = new ResultModel<T>(ResultCode.OtherException, exception.getMessage());
            }
        } catch (Exception e) {
            returnResult = new ResultModel<T>(ResultCode.InnerError, exception.getMessage());
        }

        return returnResult;
    }
}
