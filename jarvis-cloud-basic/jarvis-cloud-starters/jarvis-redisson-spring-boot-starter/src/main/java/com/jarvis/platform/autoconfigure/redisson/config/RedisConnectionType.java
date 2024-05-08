package com.jarvis.platform.autoconfigure.redisson.config;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * <p>Redis连接方式</p>
 *
 * @author Doug Wang
 * @since 1.8, 2024-05-07 09:15:50
 */
@Getter
@AllArgsConstructor
public enum RedisConnectionType {

    /**
     * 单机部署方式(默认)
     */
    STANDALONE("standalone", "单机部署方式"),
    /**
     * 哨兵部署方式
     */
    SENTINEL("sentinel", "哨兵部署方式"),
    /**
     * 集群部署方式
     */
    CLUSTER("cluster", "集群方式"),
    /**
     * 主从部署方式
     */
    MASTERSLAVE("masterslave", "主从部署方式");

    /**
     * 编码
     */
    private final String code;
    /**
     * 名称
     */
    private final String name;


}
