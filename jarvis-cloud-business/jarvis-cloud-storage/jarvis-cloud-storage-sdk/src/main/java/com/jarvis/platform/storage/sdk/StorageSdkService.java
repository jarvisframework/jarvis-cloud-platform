package com.jarvis.platform.storage.sdk;

/**
 * @author Doug Wang
 * @since 1.8, 2024-04-20 21:45:22
 */
public interface StorageSdkService {

    /**
     * 库存扣减
     *
     * @param productId 产品ID
     * @param count     数量
     * @return RestResponse<?>
     */
    String decrease(Long productId, Integer count);

}
