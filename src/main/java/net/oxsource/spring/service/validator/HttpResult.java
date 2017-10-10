package net.oxsource.spring.service.validator;

import lombok.Data;

@Data
public class HttpResult {
    private int code;
    private String msg;
    private String data;
}