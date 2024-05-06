package com.jarvis.platform.storage.modular.storage.entity;

import com.jarvis.framework.core.entity.AbstractLongIdEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Table;

/**
 * 库存实体类
 *
 * @author Doug Wang
 * @since 1.8, 2024-04-19 15:45:21
 */
@Data
@ApiModel("库存")
@Table(name = "t_storage")
@EqualsAndHashCode(callSuper = true)
public class Storage extends AbstractLongIdEntity {

    /**
     * 序列化ID
     */
    private static final long serialVersionUID = 887352934809456361L;

    /**
     * 产品id
     */
    @ApiModelProperty("产品id")
    private Long productId;

    /**
     * 总库存
     */
    @ApiModelProperty("总库存")
    private Integer total;

    /**
     * 已用库存
     */
    @ApiModelProperty("已用库存")
    private Integer used;

    /**
     * 剩余库存
     */
    @ApiModelProperty("剩余库存")
    private Integer residue;
}
