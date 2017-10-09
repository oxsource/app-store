package net.oxsource.spring.service.model;

import lombok.Data;

/**
 * 请求登录
 */
@Data
public class ReqLogin {
    private String account;
    private String password;
}