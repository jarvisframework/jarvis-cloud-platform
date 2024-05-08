package com.jarvis.platform.order.modular.redisson.service;

/**
 * @author Doug Wang
 * @since 1.8, 2024-05-08 09:54:07
 */
public interface RedissonService {

    /**
     * 测试无锁
     *
     * @param processTime 业务处理时间
     * @return {@link Long}
     */
    Long test(long processTime);

    /**
     * 测试默认分布式锁
     *
     * @param processTime 业务处理时间
     * @return {@link Long}
     */
    Long test1(long processTime);

    /**
     * 测试自定义配置分布式锁
     * <p>
     * keys: 锁名称，全局唯一<br/>
     * expire: 过期时间，防止死锁<br/>
     * acquireTimeout: 等待时间，获取不到则执行失败策略<br/>
     * </p>
     *
     * @param processTime 业务处理时间
     * @return {@link Long}
     */
    Long test2(long processTime);

    /**
     * 测试手动获取分布式锁
     *
     * @param processTime 业务处理时间
     * @return {@link Long}
     */
    Long test3(long processTime);

    /**
     * 测试5秒内只能访问1次
     *
     * @param processTime 业务处理时间
     * @return {@link Long}
     */
    Long test4(long processTime);
}
