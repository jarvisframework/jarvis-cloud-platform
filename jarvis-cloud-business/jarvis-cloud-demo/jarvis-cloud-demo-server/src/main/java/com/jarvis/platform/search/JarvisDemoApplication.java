package com.jarvis.platform.search;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author Doug Wang
 * @since 1.8, 2024-04-11 23:09:37
 */
@Slf4j
@SpringBootApplication
public class JarvisDemoApplication {
    public static void main(String[] args) {
        SpringApplication.run(JarvisDemoApplication.class, args);
        if (log.isInfoEnabled()) {
            log.info("系统启动完成...............");
        }
    }
}
