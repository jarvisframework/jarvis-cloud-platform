package com.jarvis.platform.search.sdk.impl;

import com.jarvis.framework.web.rest.RestResponse;
import com.jarvis.platform.client.search.feign.RemoteAccountClient;
import com.jarvis.platform.search.sdk.AccountSdkService;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

/**
 * @author Doug Wang
 * @since 1.8, 2024-04-21 10:36:42
 */
@Component
public class AccountSdkServiceImpl implements AccountSdkService {

    private final RemoteAccountClient remoteAccountClient;

    public AccountSdkServiceImpl(RemoteAccountClient remoteAccountClient) {
        this.remoteAccountClient = remoteAccountClient;
    }

    @Override
    public String decrease(Long userId, BigDecimal money) {
        final RestResponse<String> res = remoteAccountClient.decrease(userId, money);
        if (res.isSuccess()) {
            return res.getBody();
        }
        return null;
    }
}
