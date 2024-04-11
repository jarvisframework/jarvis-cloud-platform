package com.jarvis.platform;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author Doug Wang
 * @since 1.8, 2024-04-07 14:31:08
 */
@Slf4j
@SpringBootApplication
public class JarvisAuthApplication {

    public static void main(String[] args) {
        SpringApplication.run(JarvisAuthApplication.class, args);
        if (log.isInfoEnabled()) {
            log.info("系统启动完成...............");
        }
    }

}
