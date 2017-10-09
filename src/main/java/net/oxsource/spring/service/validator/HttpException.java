package net.oxsource.spring.service.validator;

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

    public static void verify(boolean except, int code, String msg) throws HttpException {
        if (except) {
            throw new HttpException(code, msg);
        }
    }

    public static void verify(boolean except, String msg) throws HttpException {
        if (except) {
            throw new HttpException(HttpCodes.FAILURE, msg);
        }
    }
}