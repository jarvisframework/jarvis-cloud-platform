package com.jarvis.platform.autoconfigure.redisson.util;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;

import java.util.concurrent.TimeUnit;

/**
 * <p>基于Redisson实现分布式锁</p>
 *
 * @author Doug Wang
 * @since 1.8, 2024-05-07 13:51:12
 */
@Slf4j
@RequiredArgsConstructor
public class DistributedLockClient {

    private final RedissonClient redissonClient;

    /**
     * 获取锁
     */
    public RLock getLock(String lockKey) {
        return redissonClient.getLock(lockKey);
    }

    /**
     * 加锁操作
     *
     * @return boolean
     */
    public boolean tryLock(String lockName, long expireSeconds) {
        return tryLock(lockName, 0, expireSeconds);
    }


    /**
     * 加锁操作
     *
     * @return boolean
     */
    public boolean tryLock(String lockName, long waitTime, long expireSeconds) {
        RLock rLock = getLock(lockName);
        boolean getLock = false;
        try {
            getLock = rLock.tryLock(waitTime, expireSeconds, TimeUnit.SECONDS);
            if (getLock) {
                log.info("获取锁成功,lockName={}", lockName);
            } else {
                log.info("获取锁失败,lockName={}", lockName);
            }
        } catch (InterruptedException e) {
            log.error("获取式锁异常，lockName=" + lockName, e);
        }
        return getLock;
    }

    /**
     * 锁lockKey
     *
     * @param lockKey 锁key
     * @return RLock
     */
    public RLock lock(String lockKey) {
        RLock lock = getLock(lockKey);
        lock.lock();
        return lock;
    }

    /**
     * 锁lockKey
     *
     * @param lockKey   锁key
     * @param leaseTime 租赁时间
     * @return RLock
     */
    public RLock lock(String lockKey, long leaseTime) {
        RLock lock = getLock(lockKey);
        lock.lock(leaseTime, TimeUnit.SECONDS);
        return lock;
    }


    /**
     * 解锁
     *
     * @param lockName 锁名称
     */
    public void unlock(String lockName) {
        redissonClient.getLock(lockName).unlock();
    }

}
