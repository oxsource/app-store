package net.oxsource.spring.utils;

import com.alibaba.fastjson.JSON;

import java.security.MessageDigest;

public class TextUtils {
    private static final String DEFAULT_ENCODING = "UTF-8";

    public static boolean isEmpty(String text) {
        return null == text || 0 == text.length();
    }

    public static String json(Object obj) {
        return null == obj ? "" : JSON.toJSONString(obj);
    }

    public static String md5(String text) {
        String result = "";
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte bytes[] = md.digest(text.getBytes(DEFAULT_ENCODING));
            for (int i = 0; i < bytes.length; i++) {
                String str = Integer.toHexString(bytes[i] & 0xFF);
                result += str.length() == 1 ? str + "F" : str;
            }
        } catch (Exception e) {
            e.printStackTrace();
            result = "";
        }
        return result;
    }
}