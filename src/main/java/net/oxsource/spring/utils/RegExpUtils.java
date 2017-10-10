package net.oxsource.spring.utils;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

/**
 * 正则表达式工具
 */
public class RegExpUtils {
    private static Map<String, Pattern> patternMap = new HashMap<>();
    private static String REG_PHONE = "^1[0-9]{10}$";
    private static String REG_EMAIL = "^[a-z]([a-z0-9]*[-_]?[a-z0-9]+)*@([a-z0-9]*[-_]?[a-z0-9]+)+[\\.][a-z]{2,3}([\\.][a-z]{2})?$";
    private static String REG_PASSWORD = "^([a-z0-9\\.\\@\\!\\#\\$\\%\\^\\&\\*\\(\\)]){6,20}$";

    private static Pattern obtain(String reg) {
        if (!patternMap.containsKey(reg)) {
            Pattern pattern = Pattern.compile(reg);
            patternMap.put(reg, pattern);
        }
        return patternMap.get(reg);
    }

    public static String phone(String phone) {
        if (TextUtils.isEmpty(phone)) {
            return "手机号码不能为空";
        }
        boolean match = obtain(REG_PHONE).matcher(phone).matches();
        return match ? null : "手机号码格式不正确";
    }

    public static String email(String mail) {
        if (TextUtils.isEmpty(mail)) {
            return "邮箱不能为空";
        }
        boolean match = obtain(REG_EMAIL).matcher(mail).matches();
        return match ? null : "电子邮箱格式不正确";
    }

    public static String password(String password) {
        if (TextUtils.isEmpty(password)) {
            return "密码不能为空";
        }
        boolean match = obtain(REG_PASSWORD).matcher(password).matches();
        return match ? null : "请填写数字、字母及常用特殊字符（可选）组合的6~20位密码";
    }
}