package com.jarvis.platform.auth.modular.user.security;

import com.jarvis.platform.auth.modular.organization.constant.OrganizationConstant;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.List;

/**
 * <p>用户excel</p>
 *
 * @author Doug Wang
 * @since 1.8, 2024-04-11 22:44:35
 */
@ApiModel("用户")
@Getter
@Setter
@ToString
public class SysUser implements Serializable {

    private static final long serialVersionUID = -5829964662126222544L;

    @ApiModelProperty("ID")
    private Long id;

    @ApiModelProperty("组织ID")
    private Long organizationId;

    @ApiModelProperty("组织管理方式")
    private Integer managementMode;

    @ApiModelProperty("姓名")
    private String name;

    @ApiModelProperty("登录名")
    private String loginName;

    @ApiModelProperty("证件号")
    private String identityCode;

    @ApiModelProperty("邮箱")
    private String email;

    @ApiModelProperty("手机号码")
    private String mobile;

    @ApiModelProperty("所属单位ID")
    private Long unitId;

    @ApiModelProperty("总部ID")
    private Long hqId;

    private List<Long> roleIds;

    /**
     * 是否分级管理模式
     *
     * @return boolean
     */
    public boolean isHierarchicalManagement() {
        return null != managementMode && OrganizationConstant.HIERARCHICAL_MANAGEMENT == managementMode;
    }

}
