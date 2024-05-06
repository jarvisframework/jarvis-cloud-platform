package com.jarvis.platform.order.modular.order.mapper;

import com.jarvis.framework.mybatis.mapper.LongIdSimpleEntityMapper;
import com.jarvis.platform.order.modular.order.entity.Order;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author Doug Wang
 * @since 1.8, 2024-04-19 17:03:32
 */
@Mapper
public interface OrderMapper extends LongIdSimpleEntityMapper<Order> {

}
