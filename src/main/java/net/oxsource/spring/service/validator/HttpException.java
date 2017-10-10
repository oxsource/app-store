package net.oxsource.spring.service.validator;

import net.oxsource.spring.utils.TextUtils;

public class HttpException extends Exception {
    private int code;
    private String msg;

    public HttpException(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public HttpException(String msg) {
        this(HttpCodes.FAILURE, msg);
    }

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

    /**
     * except为True时抛出异常
     *
     * @param except
     * @param msg
     * @throws HttpException
     */
    public static void verify(boolean except, int code, String msg) throws HttpException {
        if (except) {
            throw new HttpException(code, msg);
        }
    }

    /**
     * except为True时抛出异常
     *
     * @param except
     * @param msg
     * @throws HttpException
     */
    public static void verify(boolean except, String msg) throws HttpException {
        if (except) {
            throw new HttpException(HttpCodes.FAILURE, msg);
        }
    }

    /**
     * 错误信息不为空时抛出异常，并作为异常信息
     *
     * @param except 错误信息
     * @throws HttpException
     */
    public static void verify(String except) throws HttpException {
        if (!TextUtils.isEmpty(except)) {
            throw new HttpException(HttpCodes.FAILURE, except);
        }
    }
}