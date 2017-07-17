package com.beyondh.breakfast.utils;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by jliang on 7/17/2017.
 */
public class StringUtils {
    private StringUtils() {
        throw new AssertionError();
    }


    public static boolean isBlank(String str) {
        return (str == null || str.trim().length() == 0);
    }


    public static boolean isEmpty(CharSequence str) {
        return (str == null || str.length() == 0);
    }


    public static int length(CharSequence str) {
        return str == null ? 0 : str.length();
    }

    public static String ToString(List<String> stringList) {
        if (null == stringList || stringList.size() == 0) {
            return "";
        }

        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < stringList.size(); i++) {
            sb.append(stringList.get(i));
        }
        return sb.toString();
    }

    //占位符替换
    public static String fillStringByArgs(String str, String[] arr) {
        Matcher m = Pattern.compile("\\{(\\d)\\}").matcher(str);
        while (m.find()) {
            String newValue = arr[Integer.parseInt(m.group(1))];
            if (newValue == null) newValue = "";
            str = str.replace(m.group(), newValue);
        }
        return str;
    }
}
