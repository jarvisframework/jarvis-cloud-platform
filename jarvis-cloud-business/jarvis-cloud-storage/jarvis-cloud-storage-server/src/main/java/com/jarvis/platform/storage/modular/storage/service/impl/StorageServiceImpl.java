package com.jarvis.platform.storage.modular.storage.service.impl;

import com.jarvis.framework.web.service.impl.LongIdSimpleEntityServiceImpl;
import com.jarvis.platform.storage.modular.storage.entity.Storage;
import com.jarvis.platform.storage.modular.storage.mapper.StorageMapper;
import com.jarvis.platform.storage.modular.storage.service.StorageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author Doug Wang
 * @since 1.8, 2024-04-19 15:51:58
 */
@Slf4j
@Service
public class StorageServiceImpl extends LongIdSimpleEntityServiceImpl<Storage, StorageMapper>
        implements StorageService {

    @Resource
    private StorageMapper storageMapper;

    @Override
    public void decrease(Long productId, Integer count) {
        log.info("------->storage-service中扣减库存开始");
        storageMapper.decrease(productId, count);
        log.info("------->storage-service中扣减库存结束");
    }

}
