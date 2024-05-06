package com.jarvis.platform.search.sdk;

import java.math.BigDecimal;

/**
 * @author Doug Wang
 * @since 1.8, 2024-04-21 10:36:03
 */
public interface AccountSdkService {

    /**
     * 扣减账户余额
     *
     * @param userId 用户ID
     * @param money  金额
     * @return RestResponse<?>
     */
    String decrease(Long userId, BigDecimal money);

}
