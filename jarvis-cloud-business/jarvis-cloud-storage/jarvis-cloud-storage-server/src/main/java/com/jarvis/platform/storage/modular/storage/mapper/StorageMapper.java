package com.jarvis.platform.storage.modular.storage.mapper;

import com.jarvis.framework.mybatis.mapper.LongIdSimpleEntityMapper;
import com.jarvis.platform.storage.modular.storage.entity.Storage;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author Doug Wang
 * @since 1.8, 2024-04-19 15:41:07
 */
@Mapper
public interface StorageMapper extends LongIdSimpleEntityMapper<Storage> {

    /**
     * 扣减库存
     *
     * @param productId 产品ID
     * @param count     数量
     */
    void decrease(@Param("productId") Long productId, @Param("count") Integer count);

}
