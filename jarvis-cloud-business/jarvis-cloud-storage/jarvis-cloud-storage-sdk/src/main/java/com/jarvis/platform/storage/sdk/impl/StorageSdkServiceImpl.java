package com.jarvis.platform.storage.sdk.impl;

import com.jarvis.framework.web.rest.RestResponse;
import com.jarvis.platform.client.storage.feign.RemoteStorageClient;
import com.jarvis.platform.storage.sdk.StorageSdkService;
import org.springframework.stereotype.Component;

/**
 * @author Doug Wang
 * @since 1.8, 2024-04-20 21:45:55
 */
@Component
public class StorageSdkServiceImpl implements StorageSdkService {

    private final RemoteStorageClient remoteStorageClient;

    public StorageSdkServiceImpl(RemoteStorageClient remoteStorageClient) {
        this.remoteStorageClient = remoteStorageClient;
    }

    @Override
    public String decrease(Long productId, Integer count) {
        final RestResponse<String> res = remoteStorageClient.decrease(productId, count);
        if (res.isSuccess()) {
            return res.getBody();
        }
        return null;
    }
}
