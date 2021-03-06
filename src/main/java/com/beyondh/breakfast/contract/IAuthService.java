package com.beyondh.breakfast.contract;

import com.beyondh.breakfast.model.auth.User;
import com.beyondh.breakfast.model.auth.UserModel;

/**
 * Created by jliang on 7/24/2017.
 */
public interface IAuthService {
    /**
     * 登录
     * @param user
     * @return
     */
    UserModel Login(User user);
}
