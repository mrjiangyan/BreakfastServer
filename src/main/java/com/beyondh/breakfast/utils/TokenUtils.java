package com.beyondh.breakfast.utils;

import com.beyondh.breakfast.model.auth.User;

/**
 * Created by jliang on 7/24/2017.
 */
public class TokenUtils {
    private static final String ENCRYKEY="eifj123opejfo678efoeljo";

    public static String AES(User user) throws Exception{
        String content=user.getUserName()+"&"+user.getUrl()+"&"+user.getOrgId();
        return EncodeUtils.aesEncrypt(content,ENCRYKEY);
    }

    public static User DES(String encryptStr) throws Exception {
        String userInfo = EncodeUtils.aesDecrypt(encryptStr, ENCRYKEY);
        String[] userInfos = userInfo.split("&");

        User user = new User();
        user.setUserName(userInfos[0]);
        user.setUrl(userInfos[1]);
        user.setOrgId(Long.parseLong(userInfos[2]));

        return user;
    }

    public static void main(String[] args) {
//        String content = "superadmin&http://pms.beyondh.com";
//        String[] cont=content.split("&");
//
//        System.out.println("加密前：" + content);
//
//        try{
//            String encrypt = AES(content);
//            System.out.println("加密后：" + encrypt);
//            String decrypt = DES(encrypt);
//            System.out.println("解密后：" + decrypt);
//        }catch (Exception exception){
//            System.out.println("解密失败");
//        }



    }
}
