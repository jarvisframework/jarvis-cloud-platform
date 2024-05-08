package com.jarvis.platform.autoconfigure.redisson.strategy;

import com.jarvis.platform.autoconfigure.redisson.config.RedisConnectionType;
import com.jarvis.platform.autoconfigure.redisson.config.RedissonProperties;
import org.redisson.config.Config;

/**
 * <p>Redisson配置构建接口</p>
 *
 * @author Doug Wang
 * @since 1.8, 2024-05-07 09:21:56
 */
public interface RedissonConfigStrategy {

    /**
     * 根据不同的Redis配置策略创建对应的Config
     *
     * @param redissonProperties 参数
     * @return Config
     */
    Config createRedissonConfig(RedissonProperties redissonProperties);

    /**
     * 获取redis连接类型
     *
     * @return RedisConnectionType
     */
    RedisConnectionType getType();

}
