package com.jarvis.platform.autoconfigure.redisson.aspect;

import com.jarvis.platform.autoconfigure.redisson.annotation.DistributedLock;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;

import java.util.concurrent.TimeUnit;

/**
 * <p>分布式锁解析器</p>
 *
 * @author Doug Wang
 * @since 1.8, 2024-05-07 14:02:52
 */
@Slf4j
@Aspect
@RequiredArgsConstructor
public class DistributedLockAspect {

    private final RedissonClient redissonClient;

    @SneakyThrows
    @Around("@annotation(distributedLock)")
    public Object around(ProceedingJoinPoint joinPoint, DistributedLock distributedLock) {
        Object obj = null;
        log.info("进入RedisLock环绕通知...");
        String lockKey = distributedLock.lockKey();
        RLock rLock = redissonClient.getLock(lockKey);
        boolean res = false;
        //获取超时时间
        long expireSeconds = distributedLock.expireSeconds();
        //等待多久,n秒内获取不到锁，则直接返回
        long waitTime = distributedLock.waitTime();
        //执行aop
        if (rLock != null) {
            try {
                if (waitTime == -1) {
                    res = true;
                    //一直等待加锁
                    rLock.lock(expireSeconds, TimeUnit.MILLISECONDS);
                } else {
                    res = rLock.tryLock(waitTime, expireSeconds, TimeUnit.MILLISECONDS);
                }
                if (res) {
                    obj = joinPoint.proceed();
                } else {
                    log.error("获取锁异常");
                }
            } finally {
                if (res) {
                    rLock.unlock();
                }
            }
        }
        log.info("结束RedisLock环绕通知...");
        return obj;
    }
}
