package com.jarvis.platform.auth.config;

import com.jarvis.framework.autoconfigure.bizlog.ArchiveBizLogAutoConfiguration;
import com.jarvis.framework.bizlog.BizLogService;
import com.jarvis.platform.client.auth.feign.RemoteLogClient;
import org.springframework.boot.autoconfigure.AutoConfigureBefore;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Doug Wang
 * @since 1.8, 2024-04-11 21:55:09
 */
@Configuration(proxyBeanMethods = false)
@AutoConfigureBefore(ArchiveBizLogAutoConfiguration.class)
public class JarvisAuthLogAutoConfiguration {

    @Bean
    BizLogService bizLogService(RemoteLogClient remoteLogClient) {
        return new JarvisAuthBizLogService(remoteLogClient);
    }

}
