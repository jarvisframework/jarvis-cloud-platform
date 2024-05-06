package com.jarvis.platform.search.modular.account.service.impl;

import com.jarvis.framework.web.service.impl.LongIdSimpleEntityServiceImpl;
import com.jarvis.platform.search.modular.account.entity.Account;
import com.jarvis.platform.search.modular.account.mapper.AccountMapper;
import com.jarvis.platform.search.modular.account.service.AccountService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.concurrent.TimeUnit;

/**
 * 用户业务实现层
 *
 * @author Doug Wang
 * @since 1.8, 2024-04-21 09:42:39
 */
@Slf4j
@Service
public class AccountServiceImpl extends LongIdSimpleEntityServiceImpl<Account, AccountMapper> implements AccountService {
    @Override
    public void decrease(Long userId, BigDecimal money) {
        log.info("------->account-service中扣减账户余额开始");
        getBaseMapper().decrease(userId, money);
        // myTimeOut();
        // int age = 10/0;
        log.info("------->account-service中扣减账户余额结束");
    }

    private static void myTimeOut() {
        try {
            TimeUnit.SECONDS.sleep(65);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
