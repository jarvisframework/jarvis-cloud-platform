package com.jarvis.platform.auth.config;

import com.jarvis.framework.bizlog.BizLogService;
import com.jarvis.framework.bizlog.entity.BizLog;
import com.jarvis.platform.auth.modular.log.util.SystemLogUtil;
import com.jarvis.platform.client.auth.feign.RemoteLogClient;

/**
 * @author Doug Wang
 * @since 1.8, 2024-04-11 21:55:09
 */
public class JarvisAuthBizLogService implements BizLogService {

    private final RemoteLogClient remoteLogClient;

    public JarvisAuthBizLogService(RemoteLogClient remoteLogClient) {
        this.remoteLogClient = remoteLogClient;
    }

    /**
     * @see BizLogService#save(BizLog)
     */
    @Override
    public void save(BizLog log) {
        remoteLogClient.create(SystemLogUtil.toSystemLog(log));
    }

}
