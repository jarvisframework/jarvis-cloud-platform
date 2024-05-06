package com.jarvis.platform;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author Doug Wang
 * @since 1.8, 2024-04-11 23:09:37
 */
@Slf4j
@SpringBootApplication
public class JarvisStorageApplication {
    public static void main(String[] args) {
        SpringApplication.run(JarvisStorageApplication.class, args);
        if (log.isInfoEnabled()) {
            log.info("系统启动完成...............");
        }
    }
}
