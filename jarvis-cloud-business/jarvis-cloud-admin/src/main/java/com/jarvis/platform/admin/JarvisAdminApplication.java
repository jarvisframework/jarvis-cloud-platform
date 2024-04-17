package com.jarvis.platform.admin;

import de.codecentric.boot.admin.server.config.EnableAdminServer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author Doug Wang
 * @since 1.8, 2024-04-13 15:57:11
 */
@Slf4j
@EnableAdminServer
@SpringBootApplication
public class JarvisAdminApplication {
    public static void main(String[] args) {
        SpringApplication.run(JarvisAdminApplication.class, args);
        if (log.isInfoEnabled()) {
            log.info("系统启动完成...............");
        }
    }
}


