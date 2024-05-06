package com.jarvis.platform.search.modular.account.mapper;

import com.jarvis.framework.mybatis.mapper.LongIdSimpleEntityMapper;
import com.jarvis.platform.search.modular.account.entity.Account;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;

/**
 * 用户持久层
 *
 * @author Doug Wang
 * @since 1.8, 2024-04-21 09:42:28
 */
@Mapper
public interface AccountMapper extends LongIdSimpleEntityMapper<Account> {
    /**
     * 扣减账户余额
     *
     * @param userId 用户ID
     * @param money  金额
     */
    void decrease(@Param("userId") Long userId, @Param("money") BigDecimal money);
}

