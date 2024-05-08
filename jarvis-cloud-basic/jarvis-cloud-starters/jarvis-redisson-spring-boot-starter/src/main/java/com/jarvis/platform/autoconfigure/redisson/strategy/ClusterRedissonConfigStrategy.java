package com.jarvis.platform.autoconfigure.redisson.strategy;

import com.jarvis.platform.autoconfigure.redisson.config.RedisConnectionType;
import com.jarvis.platform.autoconfigure.redisson.config.RedissonConstant;
import com.jarvis.platform.autoconfigure.redisson.config.RedissonProperties;
import jodd.util.StringUtil;
import lombok.extern.slf4j.Slf4j;
import org.redisson.config.Config;
import org.springframework.stereotype.Component;

/**
 * <p>集群方式Redisson配置</p>
 *
 * @author Doug Wang
 * @since 1.8, 2024-05-07 09:32:26
 */
@Slf4j
@Component
public class ClusterRedissonConfigStrategy implements RedissonConfigStrategy {
    @Override
    public Config createRedissonConfig(RedissonProperties redissonProperties) {
        Config config = new Config();
        try {
            String address = redissonProperties.getAddress();
            String password = redissonProperties.getPassword();
            String[] addrTokens = address.split(",");
            // 设置集群(cluster)节点的服务IP和端口
            for (int i = 0; i < addrTokens.length; i++) {
                config.useClusterServers().addNodeAddress(RedissonConstant.REDIS_CONNECTION_PREFIX + addrTokens[i]);
                if (StringUtil.isNotBlank(password)) {
                    config.useClusterServers().setPassword(password);
                }
            }
            log.info("初始化集群方式Config,连接地址:" + address);
        } catch (Exception e) {
            log.error("集群Redisson初始化错误", e);
        }
        return config;
    }

    @Override
    public RedisConnectionType getType() {
        return RedisConnectionType.CLUSTER;
    }
}
