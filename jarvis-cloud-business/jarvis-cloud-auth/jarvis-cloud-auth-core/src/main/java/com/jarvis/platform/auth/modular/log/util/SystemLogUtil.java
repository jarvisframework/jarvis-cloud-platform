package com.jarvis.platform.auth.modular.log.util;

import com.jarvis.framework.bizlog.entity.BizLog;
import com.jarvis.platform.auth.modular.log.constant.LogType;
import com.jarvis.platform.auth.modular.log.entity.SystemLog;
import com.jarvis.platform.auth.modular.user.security.SysUser;

/**
 * @author Doug Wang
 * @since 1.8, 2024-04-11 21:58:57
 */
public final class SystemLogUtil {

    private SystemLogUtil() {

    }

    public static SystemLog toSystemLog(BizLog bizLog) {

        long systemId = 0L;

        final String systemIdStr = bizLog.getSystemId();

        if (null != systemIdStr && systemIdStr.matches("\\d+")) {
            systemId = Long.parseLong(systemIdStr);
        }

        final SysUser user = (SysUser) bizLog.getUserDetails();

        final SystemLog systemLog = new SystemLog();
        systemLog.setContent(bizLog.getContent());
        systemLog.setDuration((int) bizLog.getDuration());
        systemLog.setMethod(bizLog.getMethod());
        systemLog.setModule(bizLog.getModule());
        systemLog.setOperation(bizLog.getAction());

        systemLog.setRemoteAddr(bizLog.getRemoteAddr());
        systemLog.setRequestUri(bizLog.getRequestUri());
        systemLog.setSuccess(bizLog.getSuccess());
        systemLog.setSystemId(systemId);
        systemLog.setType(LogType.BIZ);
        systemLog.setUserAgent(bizLog.getUserAgent());
        systemLog.setCreatedTime(bizLog.getCreatedTime());
        if (null != user) {
            systemLog.setOperator(user.getName());
            systemLog.setCreatedBy(user.getId());
            systemLog.setUnitId(user.getUnitId());
        }

        return systemLog;
    }

}
