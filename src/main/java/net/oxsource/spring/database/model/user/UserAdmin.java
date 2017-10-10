package net.oxsource.spring.database.model.user;

import lombok.Data;
import net.oxsource.spring.database.model.base.BaseModel;

import javax.persistence.*;
import java.util.Date;

/**
 * 管理员
 */
@Data
@Entity
@Table(name = "user_admin")
public class UserAdmin extends BaseModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", unique = true)
    private int id;

    /**
     * 管理员账号
     */
    @Column(name = "account", unique = true)
    private String account;

    /**
     * 登录密钥
     */
    @Column(name = "identify")
    private String identify;

    /**
     * 0--禁用，1--启用
     */
    @Column(name = "status")
    private int status;

    /**
     * 读权限
     */
    @Column(name = "p_read")
    private boolean read;

    /**
     * 写权限
     */
    @Column(name = "p_write")
    private boolean write;

    /**
     * 创建时间
     */
    @Column(name = "create_time")
    private Date createTime;

    @Column(name = "update_time")
    private Date updateTime;
}