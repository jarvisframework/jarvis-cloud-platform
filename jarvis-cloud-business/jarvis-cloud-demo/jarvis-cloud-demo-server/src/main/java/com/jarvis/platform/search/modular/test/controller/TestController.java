package com.jarvis.platform.search.modular.test.controller;

import com.jarvis.platform.search.dubbo.api.TestDubboService;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Doug Wang
 * @since 1.8, 2024-04-16 15:25:56
 */
@RestController
public class TestController {

    @DubboReference
    private TestDubboService testDubboService;

    @GetMapping("/test")
    public String test() {
        return testDubboService.helloWorld();
    }

}
