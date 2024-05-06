package com.jarvis.platform.search.modular.account.controller;

import com.jarvis.framework.web.controller.LongIdSimpleEntityController;
import com.jarvis.framework.web.rest.RestResponse;
import com.jarvis.platform.search.modular.account.entity.Account;
import com.jarvis.platform.search.modular.account.mapper.AccountMapper;
import com.jarvis.platform.search.modular.account.service.AccountService;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

/**
 * 用户控制层
 *
 * @author Doug Wang
 * @since 1.8, 2024-04-21 09:42:40
 */
@Api(tags = "用户API")
@RestController
@RequestMapping("/account")
public class AccountController extends LongIdSimpleEntityController<Account, AccountMapper, AccountService> {
    @PostMapping("/decrease")
    public RestResponse<String> decrease(@RequestParam("userId") Long userId, @RequestParam("money") BigDecimal money) {
        getService().decrease(userId, money);
        return RestResponse.success("扣减账户余额成功！");
    }
}

