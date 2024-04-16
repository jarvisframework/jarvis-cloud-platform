package com.jarvis.platform.autoconfigure.dubbo;

import org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication;
import org.springframework.context.annotation.Configuration;

/**
 * @author Doug Wang
 * @since 1.8, 2024-04-16 10:20:36
 */
@Configuration(proxyBeanMethods = false)
@ConditionalOnWebApplication
public class JarvisDubboAutoConfiguration {

}
