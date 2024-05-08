package com.jarvis.platform.order.modular.redisson.controller;

import com.jarvis.framework.web.rest.RestResponse;
import com.jarvis.platform.order.modular.redisson.service.RedissonService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Doug Wang
 * @since 1.8, 2024-05-08 09:43:02
 */
@Slf4j
@RestController
@RequestMapping("/redisson")
@RequiredArgsConstructor
public class RedissonController {

    private final RedissonService redissonService;

    /**
     * 测试无锁
     *
     * @param processTime 业务处理时间
     * @return {@link RestResponse}
     */
    @GetMapping("/test")
    public RestResponse<Long> test(long processTime) {
        return RestResponse.success(redissonService.test(processTime));
    }

    /**
     * 测试默认分布式锁
     *
     * @param processTime 业务处理时间
     * @return {@link RestResponse}
     */
    @GetMapping("/test1")
    public RestResponse<Long> test1(long processTime) {
        return RestResponse.success(redissonService.test1(processTime));
    }

    /**
     * 测试自定义配置分布式锁
     *
     * @param processTime 业务处理时间
     * @return {@link RestResponse}
     */
    @GetMapping("/test2")
    public RestResponse<Long> test2(long processTime) {
        return RestResponse.success(redissonService.test2(processTime));
    }

    /**
     * 测试手动获取分布式锁
     *
     * @param processTime 业务处理时间
     * @return {@link RestResponse}
     */
    @GetMapping("/test3")
    public RestResponse<Long> test3(long processTime) {
        return RestResponse.success(redissonService.test3(processTime));
    }

    /**
     * 测试5秒内只能访问1次
     *
     * @param processTime 业务处理时间
     * @return {@link RestResponse}
     */
    @GetMapping("/test4")
    public RestResponse<Long> test4(long processTime) {
        return RestResponse.success(redissonService.test4(processTime));
    }

}
