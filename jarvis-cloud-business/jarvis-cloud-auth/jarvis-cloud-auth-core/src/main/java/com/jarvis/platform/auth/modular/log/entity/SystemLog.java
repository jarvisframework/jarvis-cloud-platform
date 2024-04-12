package com.jarvis.platform.auth.modular.log.entity;

import com.jarvis.framework.constant.CommonConstant;
import com.jarvis.framework.core.entity.AbstractLongIdEntity;
import com.jarvis.platform.auth.modular.log.constant.LogType;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Table;

/**
 * @author Doug Wang
 * @since 1.8, 2024-04-11 20:37:00
 */
@Table(name = "sys_system_log")
@ApiModel("登录日志")
@Getter
@Setter
@ToString
public class SystemLog extends AbstractLongIdEntity {

    /**
     * 序列化ID
     */
    private static final long serialVersionUID = -7991527001174774061L;

    @ApiModelProperty("日志类型")
    private Integer type = LogType.BIZ;

    @ApiModelProperty("模块名称")
    private String module;

    @ApiModelProperty("操作")
    private String operation;

    @ApiModelProperty("操作人")
    private String operator;

    @ApiModelProperty("ip")
    private String remoteAddr;

    @ApiModelProperty("日志内容")
    private String content;

    @ApiModelProperty("请求地址")
    private String requestUri;

    @ApiModelProperty("HTTP请求方法")
    private String method;

    @ApiModelProperty("用户代理")
    private String userAgent;

    @ApiModelProperty("是否成功：0-否，1-是")
    private Integer success = CommonConstant.YES;

    @ApiModelProperty("耗时（单位：毫秒）")
    private Integer duration;

    @ApiModelProperty("单位ID")
    private Long unitId;

    @ApiModelProperty("系统ID")
    private Long systemId;
}
