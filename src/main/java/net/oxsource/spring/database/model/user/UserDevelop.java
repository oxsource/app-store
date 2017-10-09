package net.oxsource.spring.database.model.user;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

/**
 * 应用开发者
 */
@Data
@Entity
@Table(name = "user_develop")
public class UserDevelop {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", unique = true)
    private int id;

    /**
     * 开发者唯一标识
     */
    @Column(name = "u_key", unique = true)
    private String userKey;

    /**
     * 开发者名称
     */
    @Column(name = "u_name", unique = true)
    private String userName;

    /**
     * 联系电话
     */
    @Column(name = "u_phone", unique = true)
    private String phone;

    /**
     * 电子邮件
     */
    @Column(name = "u_mail")
    private String email;

    /**
     * 登录密钥
     */
    @Column(name = "u_identify")
    private String identify;

    /**
     * 开发者网站
     */
    @Column(name = "u_site")
    private String webSite;

    /**
     * 创建时间
     */
    @Column(name = "create_time")
    private Date createTime;

    @Column(name = "update_time")
    private Date updateTime;
}