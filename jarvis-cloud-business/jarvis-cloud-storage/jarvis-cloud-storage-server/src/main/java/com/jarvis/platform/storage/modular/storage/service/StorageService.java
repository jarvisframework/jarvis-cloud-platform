package com.jarvis.platform.storage.modular.storage.service;

import com.jarvis.framework.web.service.LongIdSimpleEntityService;
import com.jarvis.platform.storage.modular.storage.entity.Storage;
import com.jarvis.platform.storage.modular.storage.mapper.StorageMapper;

/**
 * @author Doug Wang
 * @since 1.8, 2024-04-19 15:50:57
 */
public interface StorageService extends LongIdSimpleEntityService<Storage, StorageMapper> {

    /**
     * 扣减库存
     *
     * @param productId 产品ID
     * @param count     数量
     */
    void decrease(Long productId, Integer count);

}
