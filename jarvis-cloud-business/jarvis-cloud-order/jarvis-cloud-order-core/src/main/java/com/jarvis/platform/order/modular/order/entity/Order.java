package com.jarvis.platform.order.modular.order.entity;

import com.jarvis.framework.core.entity.AbstractLongIdEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Table;
import java.math.BigDecimal;

/**
 * 订单实体类
 *
 * @author Doug Wang
 * @since 1.8, 2024-04-19 15:45:21
 */
@Data
@ApiModel("订单")
@Table(name = "t_order")
@EqualsAndHashCode(callSuper = true)
public class Order extends AbstractLongIdEntity {

    /**
     * 序列化ID
     */
    private static final long serialVersionUID = 887352934809456261L;

    /**
     * 用户id
     */
    @ApiModelProperty("用户id")
    private Long userId;

    /**
     * 产品id
     */
    @ApiModelProperty("产品id")
    private Long productId;

    /**
     * 数量
     */
    @ApiModelProperty("数量")
    private Integer count;

    /**
     * 金额
     */
    @ApiModelProperty("金额")
    private BigDecimal money;

    /**
     * 订单状态: 0:创建中; 1:已完结
     */
    @ApiModelProperty("订单状态: 0:创建中; 1:已完结")
    private Integer status;
}
