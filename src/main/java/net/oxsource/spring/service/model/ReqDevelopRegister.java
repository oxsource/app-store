package net.oxsource.spring.service.model;

import lombok.Data;

/**
 * 开发者请求注册
 */
@Data
public class ReqDevelopRegister {
    /**
     * 开发者名称
     */
    private String userName;

    /**
     * 联系电话
     */
    private String phone;

    /**
     * 电子邮件
     */
    private String email;

    /**
     * 登录密钥
     */
    private String identify;

    /**
     * 开发者网站
     */
    private String webSite;
}
