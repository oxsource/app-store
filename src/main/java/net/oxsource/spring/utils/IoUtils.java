package net.oxsource.spring.utils;

import java.io.Closeable;

public class IoUtils {

    public static Exception quietClose(Closeable closeable) {
        Exception exception = null;
        try {
            closeable.close();
        } catch (Exception e) {
            e.printStackTrace();
            exception = e;
        }
        return exception;
    }
}
