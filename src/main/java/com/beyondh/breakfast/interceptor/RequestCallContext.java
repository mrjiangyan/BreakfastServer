package com.beyondh.breakfast.interceptor;

import com.beyondh.breakfast.model.auth.User;
import org.springframework.stereotype.Component;

/**
 * Created by jliang on 7/24/2017.
 */
@Component
public class RequestCallContext {
    private static ThreadLocal<User> model = new ThreadLocal<>();

    public void SetUser(User user)
    {
        model.set(user);
    }

    public User GetUser()
    {
        return model.get();
    }
}
