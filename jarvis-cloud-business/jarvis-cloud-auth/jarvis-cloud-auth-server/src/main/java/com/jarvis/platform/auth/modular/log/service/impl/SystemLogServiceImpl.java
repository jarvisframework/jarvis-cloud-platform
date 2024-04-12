package com.jarvis.platform.auth.modular.log.service.impl;

import com.jarvis.framework.web.service.impl.LongIdSimpleEntityServiceImpl;
import com.jarvis.platform.auth.modular.log.entity.SystemLog;
import com.jarvis.platform.auth.modular.log.mapper.SystemLogMapper;
import com.jarvis.platform.auth.modular.log.service.SystemLogService;
import org.springframework.stereotype.Service;

/**
 * @author Doug Wang
 * @since 1.8, 2024-04-11 22:39:50
 */
@Service
public class SystemLogServiceImpl extends LongIdSimpleEntityServiceImpl<SystemLog, SystemLogMapper>
        implements SystemLogService {
}
