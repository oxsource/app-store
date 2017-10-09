package net.oxsource.spring.database.model.app;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

/**
 * 开发者创建的应用分组
 */
@Data
@Entity
@Table(name = "app_group")
public class AppGroup {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", unique = true)
    private int id;

    /**
     * 应用分组唯一标识
     */
    @Column(name = "g_key", unique = true)
    private String groupKey;

    /**
     * 开发者唯一标识
     */
    @Column(name = "u_key")
    private String userKey;

    /**
     * 组名称
     */
    @Column(name = "g_name")
    private String name;

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
