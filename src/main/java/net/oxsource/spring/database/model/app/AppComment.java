package net.oxsource.spring.database.model.app;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

/**
 * 评论信息
 */
@Data
@Entity
@Table(name = "app_comment")
public class AppComment {
    /**
     * 评论ID
     */
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
     * 评论内容
     */
    @Column(name = "content")
    private String content;

    /**
     * 评论用户的标识
     */
    @Column(name = "u_key")
    private String userKey;

    /**
     * 创建时间
     */
    @Column(name = "create_time")
    private Date createTime;
}
