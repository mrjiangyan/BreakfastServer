package com.beyondh.breakfast.controllers;

import com.beyondh.breakfast.model.auth.User;
import com.beyondh.breakfast.model.auth.UserEncryptModel;
import com.beyondh.breakfast.model.common.ResultModel;
import com.beyondh.breakfast.service.AuthService;
import com.beyondh.breakfast.utils.ExceptionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by jliang on 7/17/2017.
 */
@RestController
@RequestMapping("/auth")
public class AuthController extends BaseController {

    @Autowired
    private AuthService authService;

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public @ResponseBody ResultModel<UserEncryptModel> Login(@RequestBody User user) {
        ResultModel<UserEncryptModel> result = null;
        try {
            UserEncryptModel userEncryptModel = authService.Login(user);
            result = new ResultModel<UserEncryptModel>(userEncryptModel);
        } catch (Exception exception) {
            return ExceptionUtils.HandleException(exception, result);
        }

        return result;
    }
}
