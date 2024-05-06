package com.jarvis.platform.search.modular.account.service;

import com.jarvis.framework.web.service.LongIdSimpleEntityService;
import com.jarvis.platform.search.modular.account.entity.Account;
import com.jarvis.platform.search.modular.account.mapper.AccountMapper;

import java.math.BigDecimal;

/**
 * 用户业务接口层
 *
 * @author Doug Wang
 * @since 1.8, 2024-04-21 09:42:38
 */
public interface AccountService extends LongIdSimpleEntityService<Account, AccountMapper> {

    /**
     * 扣减账户余额
     *
     * @param userId 用户ID
     * @param money  金额
     */
    void decrease(Long userId, BigDecimal money);

}
