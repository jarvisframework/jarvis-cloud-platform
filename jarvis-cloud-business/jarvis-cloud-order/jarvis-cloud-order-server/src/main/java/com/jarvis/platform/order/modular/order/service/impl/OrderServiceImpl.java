package com.jarvis.platform.order.modular.order.service.impl;

import com.jarvis.framework.web.service.impl.LongIdSimpleEntityServiceImpl;
import com.jarvis.platform.order.modular.order.entity.Order;
import com.jarvis.platform.order.modular.order.mapper.OrderMapper;
import com.jarvis.platform.order.modular.order.service.OrderService;
import com.jarvis.platform.search.sdk.AccountSdkService;
import com.jarvis.platform.storage.sdk.StorageSdkService;
import io.seata.core.context.RootContext;
import io.seata.spring.annotation.GlobalTransactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @author Doug Wang
 * @since 1.8, 2024-04-19 17:05:38
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class OrderServiceImpl extends LongIdSimpleEntityServiceImpl<Order, OrderMapper> implements OrderService {

    private final StorageSdkService storageSdkService;

    private final AccountSdkService accountSdkService;

    @Override
    @GlobalTransactional(name = "jarvis-transactional-order", rollbackFor = Exception.class)
    public void createOrder(Order order) {
        //XID全局事务的检查通过seata的RootContext获取
        String xid = RootContext.getXID();
        //创建订单
        log.info("==================>开始新建订单" + "\t" + "xid_order:" + xid + "\n");
        //创建之前有订单状态，0是创建中，1代表创建完成
        order.setStatus(0);
        //再开始创建订单，拿到返回值进行判断,大于0代表插入一条记录成功
        boolean inserted = this.insert(order);
        //插入成功之后再获得MySQL的实体对象
        Order orderFromDB;
        if (inserted) {
            orderFromDB = this.getById(order.getId());
            log.info("-------> 新建订单成功，orderFromDB info: " + orderFromDB + "\n");
            //新订单创建成功后开始调用storageFeignApi减少一个库存
            log.info("-------> 订单微服务开始调用storageFeignApi减少一个库存" + "\n");
            storageSdkService.decrease(orderFromDB.getProductId(), orderFromDB.getCount());
            log.info("-------> 订单微服务开始调用storageFeignApi减少一个库存操作完成！！！");

            //新订单创建成功后开始调用accountFeignApi扣用户的钱
            log.info("-------> 订单微服务开始调用accountFeignApi扣除账户余额" + "\n");
            accountSdkService.decrease(orderFromDB.getProductId(), orderFromDB.getMoney());
            log.info("-------> 订单微服务开始调用accountFeignApi扣除账户余额操作完成！！！");
            System.out.println();
            //订单完成修改状态为1
            log.info("-------> 正在修改订单状态....");
            //构建查询条件
            int updateResult = this.updateBy(createCriteriaUpdate().update(Order::getStatus, 1).filter(f -> {
                f.equal(Order::getUserId, orderFromDB.getUserId());
                f.equal(Order::getStatus, 0);
            }));
            log.info("-------> 修改订单状态完成" + "\t" + updateResult);
            log.info("-------> orderFromDB info: " + orderFromDB);
        }
        System.out.println();
        log.info("==================>结束新建订单" + "\t" + "xid_order:" + xid);
    }
}
