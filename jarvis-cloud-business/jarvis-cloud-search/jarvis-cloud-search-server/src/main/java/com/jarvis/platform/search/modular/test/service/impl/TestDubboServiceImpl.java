package com.jarvis.platform.search.modular.test.service.impl;

import com.jarvis.platform.search.dubbo.api.TestDubboService;
import org.apache.dubbo.config.annotation.DubboService;

/**
 * @author Doug Wang
 * @since 1.8, 2024-04-16 14:28:55
 */
@DubboService
public class TestDubboServiceImpl implements TestDubboService {

    @Override
    public String helloWorld() {
        return "Hello world!";
    }

}
