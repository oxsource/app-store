package net.oxsource.spring.database.model.app;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

/**
 * 开发者提交的应用产品归档文件
 */
@Data
@Entity
@Table(name = "app_artifact")
public class AppArtifact {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "a_key", unique = true)
    private String appKey;

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
     * 图标地址
     */
    @Column(name = "icon_url")
    private String iconUrl;

    /**
     * 版本号
     */
    @Column(name = "v_code")
    private int versionCode;

    /**
     * 版本名称
     */
    @Column(name = "v_name")
    private String versionName;

    /**
     * 文件名称
     */
    @Column(name = "file_name")
    private String fileName;

    /**
     * 文件大小
     */
    @Column(name = "file_size")
    private String fileSize;

    /**
     * 32位文件完整性校验值
     */
    @Column(name = "file_md5")
    private String fileMd5;

    /**
     * 文件下载地址
     */
    @Column(name = "file_url")
    private String fileUrl;

    /**
     * 文件描述
     */
    @Column(name = "file_desc")
    private String fileDesc;

    /**
     * 构建渠道
     */
    @Column(name = "build_channel")
    private String channel;

    /**
     * 是否为正式发布版
     */
    @Column(name = "is_release")
    private boolean isRelease;

    /**
     * 是否激活
     */
    @Column(name = "is_active")
    private boolean isActive;

    @Column(name = "create_time")
    private Date createTime;
}
