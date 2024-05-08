package com.jarvis.platform.autoconfigure.redisson.strategy;

import com.jarvis.platform.autoconfigure.redisson.config.RedisConnectionType;
import com.jarvis.platform.autoconfigure.redisson.config.RedissonConstant;
import com.jarvis.platform.autoconfigure.redisson.config.RedissonProperties;
import jodd.util.StringUtil;
import lombok.extern.slf4j.Slf4j;
import org.redisson.config.Config;
import org.springframework.stereotype.Component;

/**
 * <p>单例模式</p>
 *
 * @author Doug Wang
 * @since 1.8, 2024-05-07 09:22:51
 */
@Slf4j
@Component
public class StandaloneRedissonConfigStrategy implements RedissonConfigStrategy {
    @Override
    public Config createRedissonConfig(RedissonProperties redissonProperties) {
        Config config = new Config();
        try {
            String address = redissonProperties.getAddress();
            String password = redissonProperties.getPassword();
            int database = redissonProperties.getDatabase();
            String redisAddr = RedissonConstant.REDIS_CONNECTION_PREFIX + address;
            config.useSingleServer().setAddress(redisAddr);
            config.useSingleServer().setDatabase(database);
            if (StringUtil.isNotBlank(password)) {
                config.useSingleServer().setPassword(password);
            }
            log.info("初始化Redisson单机配置,连接地址:" + address);
        } catch (Exception e) {
            log.error("单机Redisson初始化错误", e);
        }
        return config;
    }

    @Override
    public RedisConnectionType getType() {
        return RedisConnectionType.STANDALONE;
    }
}
