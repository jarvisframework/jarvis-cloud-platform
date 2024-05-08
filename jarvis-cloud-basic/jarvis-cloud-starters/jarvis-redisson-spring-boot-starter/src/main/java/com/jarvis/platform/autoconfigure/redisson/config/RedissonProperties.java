package com.jarvis.platform.autoconfigure.redisson.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * <p>Redisson配置</p>
 *
 * @author Doug Wang
 * @since 1.8, 2024-05-07 09:13:54
 */
@Data
@ConfigurationProperties(prefix = "jarvis.redisson")
public class RedissonProperties {

    /**
     * redis主机地址，ip：port，多个用逗号(,)分隔
     */
    private String address;

    /**
     * 连接类型
     */
    private RedisConnectionType type;

    /**
     * 密码
     */
    private String password;

    /**
     * 数据库(默认0)
     */
    private int database;

    /**
     * 是否装配redisson配置
     */
    private Boolean enabled = true;
}
