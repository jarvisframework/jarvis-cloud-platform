package com.jarvis.platform.client.auth.feign;

import com.jarvis.framework.openfeign.annotation.PermitRequest;
import com.jarvis.framework.web.rest.RestResponse;
import com.jarvis.platform.auth.constant.AuthConstant;
import com.jarvis.platform.auth.modular.log.entity.SystemLog;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * @author Doug Wang
 * @since 1.8, 2024-04-11 20:37:00
 */
@FeignClient(contextId = "auth.log.feign.RemoteLogClient", name = AuthConstant.SERVICE_NAME, path = "/log")
public interface RemoteLogClient {

    /**
     * 保存日志
     *
     * @param entity 日志内容
     * @return RestResponse
     */
    @PermitRequest
    @PostMapping("/system")
    RestResponse<?> create(@RequestBody SystemLog entity);

}
