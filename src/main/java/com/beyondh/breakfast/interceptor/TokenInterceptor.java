package com.beyondh.breakfast.interceptor;

import com.beyondh.breakfast.model.auth.User;
import com.beyondh.breakfast.utils.TokenUtils;
import com.beyondh.breakfast.utils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by jliang on 7/24/2017.
 */
@Component
public class TokenInterceptor implements HandlerInterceptor {

    @Autowired
    private RequestCallContext requestCallContext;

    private static final String HTTP_HEADER_TOKEN_NAME="UserToken";

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        checkHeaderAuth(request,response);
        return true;
    }

    private boolean checkHeaderAuth(HttpServletRequest request, HttpServletResponse response) throws IOException {

        String userToken=request.getHeader(HTTP_HEADER_TOKEN_NAME);
        User requestUser=null;
        if(StringUtils.isEmpty(userToken)){
            throw new IllegalArgumentException("请求无效");
         }
         try{
             requestUser= TokenUtils.DES(userToken);
         }
         catch (Exception e){
             throw new IllegalArgumentException("请求无效");
         }
        requestCallContext.SetUser(requestUser);

        return true;

    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
