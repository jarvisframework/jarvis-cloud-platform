package com.jarvis.platform.client.storage.feign;

import com.jarvis.framework.openfeign.annotation.PermitRequest;
import com.jarvis.framework.web.rest.RestResponse;
import com.jarvis.platform.storage.constant.StorageConstant;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author Doug Wang
 * @since 1.8, 2024-04-19 14:12:56
 */
@FeignClient(contextId = "storage.feign.RemoteStorageClient", name = StorageConstant.SERVICE_NAME)
public interface RemoteStorageClient {

    /**
     * 库存扣减
     *
     * @param productId 产品ID
     * @param count     数量
     * @return RestResponse<?>
     */
    @PermitRequest
    @PostMapping(value = "/storage/decrease")
    RestResponse<String> decrease(@RequestParam("productId") Long productId, @RequestParam("count") Integer count);

}
