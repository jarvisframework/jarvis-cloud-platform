package com.jarvis.platform.autoconfigure.redisson.util;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.lang.Nullable;
import org.springframework.util.Assert;

/**
 * <p>SpringContextHolder工具类</p>
 *
 * @author Doug Wang
 * @since 1.8, 2024-05-07 11:41:18
 */
public class SpringContextHolder implements ApplicationContextAware, DisposableBean {
    private static ApplicationContext applicationContext;

    @SuppressWarnings("unchecked")
    public static <T> T getBean(String beanName) {
        assertApplicationContext();
        return (T) SpringContextHolder.applicationContext.getBean(beanName);
    }

    public static <T> T getBean(Class<T> typeName) {
        assertApplicationContext();
        return applicationContext.getBean(typeName);
    }

    private static void assertApplicationContext() {
        Assert.notNull(applicationContext, "applicationContext");
    }

    public static void clearHolder() {
        applicationContext = null;
    }

    @Override
    public void setApplicationContext(@Nullable ApplicationContext applicationContext) throws BeansException {
        SpringContextHolder.applicationContext = applicationContext;
    }

    public static ApplicationContext getApplicationContext() {
        assertApplicationContext();
        return SpringContextHolder.applicationContext;
    }

    @Override
    public void destroy() {
        SpringContextHolder.clearHolder();
    }
}
