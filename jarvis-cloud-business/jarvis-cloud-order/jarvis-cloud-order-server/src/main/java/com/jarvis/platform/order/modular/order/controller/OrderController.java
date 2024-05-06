package com.jarvis.platform.order.modular.order.controller;


import com.jarvis.framework.web.controller.LongIdSimpleEntityController;
import com.jarvis.framework.web.rest.RestResponse;
import com.jarvis.platform.order.modular.order.entity.Order;
import com.jarvis.platform.order.modular.order.mapper.OrderMapper;
import com.jarvis.platform.order.modular.order.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Doug Wang
 * @since 1.8, 2024-04-21 10:49:15
 */
@Slf4j
@RestController
@RequestMapping("/order")
public class OrderController extends LongIdSimpleEntityController<Order, OrderMapper, OrderService> {

    @GetMapping("/create")
    public RestResponse<?> create(Order order) {
        getService().createOrder(order);
        return RestResponse.success(order);
    }
}
