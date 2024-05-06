package com.jarvis.platform.search.modular.account.entity;

import com.jarvis.framework.core.entity.AbstractLongIdEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Table;
import java.math.BigDecimal;

/**
 * 用户实体类
 *
 * @author Doug Wang
 * @since 1.8, 2024-04-21 09:42:22
 */
@Data
@ApiModel("用户")
@Table(name = "t_account")
@EqualsAndHashCode(callSuper = true)
public class Account extends AbstractLongIdEntity {

    /**
     * 序列化ID
     */
    private static final long serialVersionUID = -35810024180118805L;

    /**
     * 用户id
     */
    @ApiModelProperty("用户id")
    private Long userId;

    /**
     * 总额度
     */
    @ApiModelProperty("总额度")
    private BigDecimal total;

    /**
     * 已用余额
     */
    @ApiModelProperty("已用余额")
    private BigDecimal used;

    /**
     * 剩余可用额度
     */
    @ApiModelProperty("剩余可用额度")
    private BigDecimal residue;

}
