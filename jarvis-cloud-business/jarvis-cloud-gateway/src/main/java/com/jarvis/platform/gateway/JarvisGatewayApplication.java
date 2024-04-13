package com.jarvis.platform.gateway;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author Doug Wang
 * @since 1.8, 2024-04-13 15:57:11
 */
@Slf4j
@SpringBootApplication
public class JarvisGatewayApplication {
    public static void main(String[] args) {
        SpringApplication.run(JarvisGatewayApplication.class, args);
        if (log.isInfoEnabled()) {
            log.info("系统启动完成...............");
        }
    }
}


