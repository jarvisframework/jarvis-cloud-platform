package com.jarvis.platform.auth.modular.log.mapper;

import com.jarvis.framework.mybatis.mapper.LongIdSimpleEntityMapper;
import com.jarvis.platform.auth.modular.log.entity.SystemLog;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author Doug Wang
 * @since 1.8, 2024-04-11 22:38:46
 */
@Mapper
public interface SystemLogMapper extends LongIdSimpleEntityMapper<SystemLog> {

}
