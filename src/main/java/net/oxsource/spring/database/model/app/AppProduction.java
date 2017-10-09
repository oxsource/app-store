package net.oxsource.spring.database.model.app;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

/**
 * 开发者提交的应用产品
 */
@Data
@Entity
@Table(name = "app_production")
public class AppProduction {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", unique = true)
    private int id;

    /**
     * 应用唯一标识，由系统生成
     */
    @Column(name = "a_key", unique = true)
    private String appKey;

    /**
     * 开发者唯一标识
     */
    @Column(name = "u_key")
    private String userKey;

    /**
     * 应用分组唯一标识
     */
    @Column(name = "g_key")
    private String groupKey;

    /**
     * 应用名称
     */
    @Column(name = "a_name")
    private String appName;

    /**
     * 1-ANDROID，2-IOS，3-其他
     */
    @Column(name = "platform")
    private String platform;

    /**
     * 应用标识，应用包名或应用ID
     */
    @Column(name = "identify")
    private String identify;

    /**
     * 评分
     */
    @Column(name = "score")
    private String score;

    /**
     * 下载次数
     */
    @Column(name = "downloads")
    private String downloads;

    /**
     * 统计激活数量
     */
    @Column(name = "actives")
    private String actives;

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