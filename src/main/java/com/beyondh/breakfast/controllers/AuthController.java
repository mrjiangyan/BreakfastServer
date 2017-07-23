package com.beyondh.breakfast.controllers;

import com.beyondh.breakfast.contract.IAuthService;
import com.beyondh.breakfast.model.auth.User;
import com.beyondh.breakfast.model.auth.UserEncryptModel;
import com.beyondh.breakfast.model.common.ApiResponse;
import com.beyondh.breakfast.utils.TokenUtils;
import com.beyondh.breakfast.utils.ExceptionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;

/**
 * Created by jliang on 7/17/2017.
 */
@RestController
@RequestMapping("/auth")
public class AuthController extends BaseController {

    @Autowired
    private IAuthService authService;

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ResponseBody
    public ApiResponse<UserEncryptModel> Login(@RequestBody User user, HttpServletResponse httpServletResponse) {
        ApiResponse<UserEncryptModel> result = new ApiResponse<>();
        UserEncryptModel userEncryptModel=null;
        try {
            userEncryptModel = authService.Login(user);
            result.setData(userEncryptModel);
            httpServletResponse.addHeader("LoginId", TokenUtils.AES(user));
        } catch (Exception exception) {
            return ExceptionUtils.HandleException(exception,result);
        }

        return result;
    }
}
