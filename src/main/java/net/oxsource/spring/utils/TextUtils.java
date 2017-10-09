package net.oxsource.spring.utils;

import org.apache.tomcat.util.security.MD5Encoder;

import java.io.UnsupportedEncodingException;

public class TextUtils {
    private static final String DEFAULT_ENCODING = "UTF-8";

    public static boolean isEmpty(String text) {
        return null == text || 0 == text.length();
    }
}
