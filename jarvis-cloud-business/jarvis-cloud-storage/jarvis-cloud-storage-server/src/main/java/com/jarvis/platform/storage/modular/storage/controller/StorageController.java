package com.jarvis.platform.storage.modular.storage.controller;

import com.jarvis.framework.web.controller.LongIdSimpleEntityController;
import com.jarvis.framework.web.rest.RestResponse;
import com.jarvis.platform.storage.modular.storage.entity.Storage;
import com.jarvis.platform.storage.modular.storage.mapper.StorageMapper;
import com.jarvis.platform.storage.modular.storage.service.StorageService;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Doug Wang
 * @since 1.8, 2024-04-19 15:53:50
 */
@Api(tags = "库存API")
@RestController
@RequestMapping("/storage")
public class StorageController extends LongIdSimpleEntityController<Storage, StorageMapper, StorageService> {

    @PostMapping("/decrease")
    public RestResponse<String> decrease(@RequestParam("productId") Long productId, @RequestParam("count") Integer count) {
        getService().decrease(productId, count);
        return RestResponse.success("扣减库存成功!");
    }


}
