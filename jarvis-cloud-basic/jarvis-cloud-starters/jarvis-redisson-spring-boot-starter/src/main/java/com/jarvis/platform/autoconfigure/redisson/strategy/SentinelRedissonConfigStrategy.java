package com.jarvis.platform.autoconfigure.redisson.strategy;

import com.jarvis.platform.autoconfigure.redisson.config.RedisConnectionType;
import com.jarvis.platform.autoconfigure.redisson.config.RedissonConstant;
import com.jarvis.platform.autoconfigure.redisson.config.RedissonProperties;
import jodd.util.StringUtil;
import lombok.extern.slf4j.Slf4j;
import org.redisson.config.Config;
import org.springframework.stereotype.Component;

/**
 * <p>哨兵方式Redis连接配置</p>
 *
 * @author Doug Wang
 * @since 1.8, 2024-05-07 09:25:22
 */
@Slf4j
@Component
public class SentinelRedissonConfigStrategy implements RedissonConfigStrategy {
    @Override
    public Config createRedissonConfig(RedissonProperties redissonProperties) {
        Config config = new Config();
        try {
            String address = redissonProperties.getAddress();
            String password = redissonProperties.getPassword();
            int database = redissonProperties.getDatabase();
            String[] addrTokens = address.split(",");
            String sentinelAliasName = addrTokens[0];
            // 设置redis配置文件sentinel.conf配置的sentinel别名
            config.useSentinelServers().setMasterName(sentinelAliasName);
            config.useSentinelServers().setDatabase(database);
            if (StringUtil.isNotBlank(password)) {
                config.useSentinelServers().setPassword(password);
            }
            // 设置哨兵节点的服务IP和端口
            for (int i = 1; i < addrTokens.length; i++) {
                config.useSentinelServers().addSentinelAddress(RedissonConstant.REDIS_CONNECTION_PREFIX + addrTokens[i]);
            }
            log.info("初始化哨兵方式Config,redisAddress:" + address);
        } catch (Exception e) {
            log.error("哨兵Redisson初始化错误", e);
        }
        return config;
    }

    @Override
    public RedisConnectionType getType() {
        return RedisConnectionType.SENTINEL;
    }
}
