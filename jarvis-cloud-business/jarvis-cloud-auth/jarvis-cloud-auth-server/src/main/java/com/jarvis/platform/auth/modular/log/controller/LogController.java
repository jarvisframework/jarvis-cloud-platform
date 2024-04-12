package com.jarvis.platform.auth.modular.log.controller;

import com.jarvis.framework.web.rest.RestResponse;
import com.jarvis.framework.web.util.SwaggerAipHttpMethod;
import com.jarvis.platform.auth.modular.log.entity.SystemLog;
import com.jarvis.platform.auth.modular.log.service.SystemLogService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Doug Wang
 * @since 1.8, 2024-04-11 22:33:00
 */
@RestController
@RequestMapping("/log")
@Api(tags = "日志管理")
@RequiredArgsConstructor
public class LogController {

    private final SystemLogService systemLogService;

    @ApiOperation(value = "新增操作日志", httpMethod = SwaggerAipHttpMethod.POST, hidden = true)
    @PostMapping("/system")
    public RestResponse<?> create(@RequestBody SystemLog entity) {
        systemLogService.insert(entity);
        return RestResponse.success("OK");
    }

}
