package com.jarvis.platform.auth.constant;

import com.jarvis.framework.util.ServiceNameUtil;

/**
 * @author Doug Wang
 * @since 1.8, 2024-04-11 20:39:15
 */
public final class AuthConstant {

    /**
     * 系统管理服务名称
     */
    public static final String SERVICE_NAME = "jarvis-cloud-auth-server" + ServiceNameUtil.HOST_OWNER;

    /**
     * 公共ID
     */
    public static final long COMMON_ID = 0L;

    /**
     * 预留100以内
     */
    public static final int RESERVED_NO = 100;
}
