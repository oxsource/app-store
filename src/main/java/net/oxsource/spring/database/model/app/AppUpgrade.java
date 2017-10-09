package net.oxsource.spring.database.model.app;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

/**
 * 升级配置
 */
@Data
@Entity
@Table(name = "app_upgrade")
public class AppUpgrade {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", unique = true)
    private int id;

    /**
     * 应用密钥
     */
    @Column(name = "app_key")
    private String appKey;

    /**
     * 版本号
     */
    @Column(name = "version_code")
    private int versionCode;

    /**
     * 升级渠道
     */
    @Column(name = "upgrade_channel")
    private String channel;

    /**
     * 升级策略：1--选择更新，2--强制更新
     */
    @Column(name = "upgrade_policy")
    private int policy;

    /**
     * 创建时间
     */
    @Column(name = "create_time")
    private Date createTime;

    /**
     * 更新时间
     */
    @Column(name = "update_time")
    private Date updateTime;
}