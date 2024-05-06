package com.jarvis.platform.order.modular.order.service;

import com.jarvis.framework.web.service.LongIdSimpleEntityService;
import com.jarvis.platform.order.modular.order.entity.Order;
import com.jarvis.platform.order.modular.order.mapper.OrderMapper;

/**
 * @author Doug Wang
 * @since 1.8, 2024-04-19 17:02:19
 */
public interface OrderService extends LongIdSimpleEntityService<Order, OrderMapper> {

    /**
     * 创建订单
     *
     * @param order 订单
     */
    void createOrder(Order order);

}
