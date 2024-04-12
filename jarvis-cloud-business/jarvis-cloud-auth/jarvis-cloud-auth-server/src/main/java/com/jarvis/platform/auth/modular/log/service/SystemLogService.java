package com.jarvis.platform.auth.modular.log.service;

import com.jarvis.framework.web.service.LongIdSimpleEntityService;
import com.jarvis.platform.auth.modular.log.entity.SystemLog;
import com.jarvis.platform.auth.modular.log.mapper.SystemLogMapper;

/**
 * @author Doug Wang
 * @since 1.8, 2024-04-11 22:37:44
 */
public interface SystemLogService extends LongIdSimpleEntityService<SystemLog, SystemLogMapper> {
}
