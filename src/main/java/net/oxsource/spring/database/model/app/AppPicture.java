package net.oxsource.spring.database.model.app;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

/**
 * 应用图库
 */
@Data
@Entity
@Table(name = "app_picture")
public class AppPicture {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", unique = true)
    private int id;

    /**
     * 被评论应用的标识
     */
    @Column(name = "a_key", unique = true)
    private String appKey;

    /**
     * 存储路径
     */
    @Column(name = "url")
    private String url;

    /**
     * 类型代表：1--屏幕截图，2--评论截图
     */
    @Column(name = "deputy")
    private String deputy;

    @Column(name = "create_time")
    private Date createTime;
}