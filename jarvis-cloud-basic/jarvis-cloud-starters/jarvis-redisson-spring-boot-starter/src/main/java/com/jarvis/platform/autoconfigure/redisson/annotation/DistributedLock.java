package com.jarvis.platform.autoconfigure.redisson.annotation;

import java.lang.annotation.*;

/**
 * <p>Redisson分布式锁注解</p>
 *
 * @author Doug Wang
 * @since 1.8, 2024-05-07 13:57:46
 */
@Inherited
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.METHOD})
public @interface DistributedLock {
    /**
     * 锁Key
     *
     * @return String
     */
    String lockKey() default "";

    /**
     * 锁超时时间,默认30000毫秒
     *
     * @return int
     */
    long expireSeconds() default 30000L;

    /**
     * 等待加锁超时时间,默认10000毫秒 -1 则表示一直等待
     *
     * @return int
     */
    long waitTime() default 10000L;
}
