package com.jarvis.platform.autoconfigure.dubbo;

import org.apache.dubbo.config.spring.context.annotation.DubboComponentScan;
import org.apache.dubbo.spring.boot.autoconfigure.DubboConfigurationProperties;
import org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @author Doug Wang
 * @since 1.8, 2024-04-16 10:20:36
 */
@Configuration(proxyBeanMethods = false)
@ConditionalOnWebApplication
@DubboComponentScan(value = "com.jarvis.platform")
@EnableConfigurationProperties(DubboConfigurationProperties.class)
public class JarvisDubboAutoConfiguration {

}
