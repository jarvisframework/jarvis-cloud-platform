package com.jarvis.platform.search.modular.test.controller;

import com.jarvis.platform.auth.modular.log.entity.SystemLog;
import com.jarvis.platform.client.auth.feign.RemoteLogClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Doug Wang
 * @since 1.8, 2024-04-12 13:16:45
 */
@RestController
public class TestController {

    @Autowired
    private RemoteLogClient remoteLogClient;

    @GetMapping("/test")
    public String test() {
        remoteLogClient.create(new SystemLog());
        return "ok!";
    }

}
