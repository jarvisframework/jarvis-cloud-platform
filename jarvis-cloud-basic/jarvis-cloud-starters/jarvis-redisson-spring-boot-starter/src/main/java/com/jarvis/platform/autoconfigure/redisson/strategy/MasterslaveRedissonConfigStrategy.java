package com.jarvis.platform.autoconfigure.redisson.strategy;

import com.jarvis.platform.autoconfigure.redisson.config.RedisConnectionType;
import com.jarvis.platform.autoconfigure.redisson.config.RedissonConstant;
import com.jarvis.platform.autoconfigure.redisson.config.RedissonProperties;
import jodd.util.StringUtil;
import lombok.extern.slf4j.Slf4j;
import org.redisson.config.Config;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>主从方式Redisson配置</p>
 *
 * @author Doug Wang
 * @since 1.8, 2024-05-07 09:26:26
 */
@Slf4j
@Component
public class MasterslaveRedissonConfigStrategy implements RedissonConfigStrategy {
    @Override
    public Config createRedissonConfig(RedissonProperties redissonProperties) {
        Config config = new Config();
        try {
            String address = redissonProperties.getAddress();
            String password = redissonProperties.getPassword();
            int database = redissonProperties.getDatabase();
            String[] addrTokens = address.split(",");
            String masterNodeAddr = addrTokens[0];
            // 设置主节点ip
            config.useMasterSlaveServers().setMasterAddress(masterNodeAddr);
            if (StringUtil.isNotBlank(password)) {
                config.useMasterSlaveServers().setPassword(password);
            }
            config.useMasterSlaveServers().setDatabase(database);
            // 设置从节点，移除第一个节点，默认第一个为主节点
            List<String> slaveList = new ArrayList<>();
            for (String addrToken : addrTokens) {
                slaveList.add(RedissonConstant.REDIS_CONNECTION_PREFIX + addrToken);
            }
            slaveList.remove(0);

            config.useMasterSlaveServers().addSlaveAddress((String[]) slaveList.toArray());
            log.info("初始化主从方式Config,redisAddress:" + address);
        } catch (Exception e) {
            log.error("主从Redisson初始化错误", e);
        }
        return config;
    }

    @Override
    public RedisConnectionType getType() {
        return RedisConnectionType.MASTERSLAVE;
    }
}
