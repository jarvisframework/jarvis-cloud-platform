package com.jarvis.platform.autoconfigure.redisson.strategy;

import com.jarvis.platform.autoconfigure.redisson.config.RedisConnectionType;
import com.jarvis.platform.autoconfigure.redisson.config.RedissonProperties;
import com.jarvis.platform.autoconfigure.redisson.util.SpringContextHolder;
import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>Redisson连接方式配置工厂</p>
 *
 * @author Doug Wang
 * @since 1.8, 2024-05-07 09:32:26
 */
public class RedissonConfigFactory {

    private final Map<String, RedissonConfigStrategy> redissonConfigStrategies;

    public RedissonConfigFactory() {
        redissonConfigStrategies = new HashMap<>();
        Map<String, RedissonConfigStrategy> strategies = SpringContextHolder.getApplicationContext().getBeansOfType(RedissonConfigStrategy.class);
        strategies.forEach((k, v) -> redissonConfigStrategies.put(v.getType().getCode(), v));
    }

    public RedissonClient createRedissonClient(RedissonProperties redissonProperties) {
        RedisConnectionType connectionType = redissonProperties.getType();
        RedissonConfigStrategy redissonConfigStrategy = redissonConfigStrategies.get(connectionType.getCode());
        Config config = redissonConfigStrategy.createRedissonConfig(redissonProperties);
        return Redisson.create(config);
    }

}
