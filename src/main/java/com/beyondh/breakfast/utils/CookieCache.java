package com.beyondh.breakfast.utils;

import com.beyondh.breakfast.model.auth.User;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by jliang on 7/17/2017.
 */
public class CookieCache {

    private static final String SEPORATOR = "@@@@";
    private static Map<String, String> concurrentHashMap = new ConcurrentHashMap<String, String>();

    public static void Save(User user, String value) {
        String key = getKey(user);
        concurrentHashMap.put(key, value);
    }

    public static String Get(User user) {
        String key = getKey(user);
        if (!concurrentHashMap.containsKey(key)) {
            return "";
        }
        return concurrentHashMap.get(key);
    }

    public static void Remove(User user) {
        String key = getKey(user);
        if (concurrentHashMap.containsKey(key)) {
            concurrentHashMap.remove(key);
        }
    }

    private static String getKey(User user) {
        if (null == user) {
            throw new IllegalArgumentException("user is illegal");
        }

        return user.getUrl() + SEPORATOR + user.getUserName();
    }
}
