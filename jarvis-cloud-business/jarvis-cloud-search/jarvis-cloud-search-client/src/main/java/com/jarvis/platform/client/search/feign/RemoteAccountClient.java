package com.jarvis.platform.client.search.feign;

import com.jarvis.framework.openfeign.annotation.PermitRequest;
import com.jarvis.framework.web.rest.RestResponse;
import com.jarvis.platform.search.constant.SearchConstant;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;

/**
 * @author Doug Wang
 * @since 1.8, 2024-04-21 10:23:19
 */
@FeignClient(contextId = "search.feign.RemoteStorageClient", name = SearchConstant.SERVICE_NAME)
public interface RemoteAccountClient {

    /**
     * 库存扣减
     *
     * @param userId 用户ID
     * @param money  金额
     * @return RestResponse<?>
     */
    @PermitRequest
    @PostMapping(value = "/account/decrease")
    RestResponse<String> decrease(@RequestParam("userId") Long userId, @RequestParam("money") BigDecimal money);

}
