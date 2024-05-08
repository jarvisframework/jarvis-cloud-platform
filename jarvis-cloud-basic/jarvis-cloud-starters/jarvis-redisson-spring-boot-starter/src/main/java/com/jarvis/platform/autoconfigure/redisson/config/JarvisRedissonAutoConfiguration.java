package com.jarvis.platform.autoconfigure.redisson.config;

import com.jarvis.platform.autoconfigure.redisson.aspect.DistributedLockAspect;
import com.jarvis.platform.autoconfigure.redisson.strategy.RedissonConfigFactory;
import com.jarvis.platform.autoconfigure.redisson.util.DistributedLockClient;
import com.jarvis.platform.autoconfigure.redisson.util.SpringContextHolder;
import lombok.extern.slf4j.Slf4j;
import org.redisson.api.RedissonClient;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * <p>description</p>
 *
 * @author Doug Wang
 * @since 1.8, 2024-05-07 13:27:28
 */
@Slf4j
@Configuration
@ConditionalOnClass(RedissonProperties.class)
@EnableConfigurationProperties(RedissonProperties.class)
//自动装载连接策略
@ComponentScan(basePackages = {"com.jarvis.platform.autoconfigure.redisson.strategy"})
public class JarvisRedissonAutoConfiguration {

    @Bean
    @ConditionalOnMissingBean(RedissonClient.class)
    public RedissonClient redissonClient(RedissonProperties redissonProperties) {
        RedissonConfigFactory redissonConfigFactory = new RedissonConfigFactory();
        log.info("RedissonManager初始化完成,当前连接方式:" + redissonProperties.getType() + ",连接地址:" + redissonProperties.getAddress());
        return redissonConfigFactory.createRedissonClient(redissonProperties);
    }

    @Bean
    public DistributedLockClient distributeLockClient(RedissonClient redissonClient) {
        return new DistributedLockClient(redissonClient);
    }

    @Bean
    public DistributedLockAspect distributedLockAspect(RedissonClient redissonClient) {
        return new DistributedLockAspect(redissonClient);
    }

    @Bean
    SpringContextHolder applicationContextHolder() {
        return new SpringContextHolder();
    }
}
