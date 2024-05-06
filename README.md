# Jarvis 微服务基础平台

------

## 一 项目介绍

### 1. 介绍

​ Jarvis 微服务基础平台是一个建立在**jarvis-framework**之上的微服务开发平台。该平台旨在利用当前流行的微服务技术，快速构建一个适合企业使用的微服务框架。Jarvis
微服务基础平台不仅提供了强大的微服务开发功能，还包含了丰富的工具集，可以帮助开发团队快速开发、测试和部署微服务应用。通过Jarvis
微服务基础平台，开发团队可以更加高效地构建出稳定、可靠的微服务架构，从而更好地满足企业的需求。立足于**jarvis-framework**
，Jarvis 微服务基础平台致力于为企业提供一个高效、可靠的微服务开发环境，助力企业实现数字化转型。

### 2. 业务流程

### 3. 功能架构

### 4. 技术架构

### 5. 核心技术

- SpringBoot：简化新Spring应用的初始搭建以及开发过程


- SpringCloud：基于Spring Boot实现的云原生应用开发工具，SpringCloud使用的技术：（Spring Cloud Gateway、Spring Cloud
  OpenFeign、Spring Cloud Alibaba Nacos等）


- Redis：缓存数据库

- Redisson：基于redis的Java驻内存数据网格，实现分布式锁

- RabbitMQ：消息中间件

- ElasticSearch +Kibana: 全文检索服务器 +可视化数据监控

- ThreadPoolExecutor：线程池来实现异步操作，提高效率

- OSS：文件存储服务

- Knife4j（Swagger）：Api接口文档工具

- Nginx：负载均衡

- MySQL：关系型数据库

- 微信支付

- 微信小程序

- Docker：容器技术

- DockerFile：管理Docker镜像命令文本

### 6. 项目模块

```lua
jarvis-cloud-platform -- 父项目，公共依赖
│ ├─jarvis-business -- 业务模块一级工程
│ │ ├─user-center -- 用户中心[7000]
│ │ ├─file-center -- 文件中心[5000]
│ │ ├─search-center -- 搜索中心
│ │ │ ├─search-client -- 搜索中心客户端
│ │ │ ├─search-server -- 搜索中心服务端[7100]
│ │─jarvis-basic-- 通用工具一级工程
│ │ ├─jarvis-auth-client-spring-boot-starter -- 封装spring security client端的通用操作逻辑
│ │ ├─jarvis-common-core -- 封装通用操作逻辑
│ │ ├─jarvis-common-spring-boot-starter -- 封装通用操作逻辑
│ │ ├─jarvis-db-spring-boot-starter -- 封装数据库通用操作逻辑
│ │ ├─jarvis-log-spring-boot-starter -- 封装log通用操作逻辑
│ │ ├─jarvis-redis-spring-boot-starter -- 封装Redis通用操作逻辑
│ │ ├─jarvis-loadbalancer-spring-boot-starter -- 封装Loadbalancer和Feign的通用操作逻辑
│ │ ├─jarvis-sentinel-spring-boot-starter -- 封装Sentinel的通用操作逻辑
│ │ ├─jarvis-elasticsearch-spring-boot-starter -- 封装Elasticsearch通用操作逻辑
│ │ ├─jarvis-oss-spring-boot-starter -- 封装对象存储通用操作逻辑
│ │ ├─jarvis-zookeeper-spring-boot-starter -- 封装Zookeeper通用操作逻辑
│ ├─jarvis-config -- 配置中心
│ ├─jarvis-doc -- 项目文档
│ ├─jarvis-gateway -- api网关一级工程
│ │ ├─sc-gateway -- spring-cloud-gateway[9900]
│ ├─jarvis-monitor -- 监控一级工程
│ │ ├─sc-admin -- 应用监控[6500]
│ │ ├─log-center -- 日志中心[7200]
│ ├─jarvis-uaa -- spring-security认证中心[8000]
│ ├─jarvis-register -- 注册中心Nacos[8848]
│ ├─jarvis-web -- 前端一级工程
│ │ ├─layui-web -- layui前端[8066]
│ │ ├─react-web -- react前端[8066]
│ ├─jarvis-demo -- demo一级工程
│ │ ├─dubbo-demo -- dubbo服务demo
│ │ ├─resource-server-demo -- 资源服务器demo
│ │ ├─seata-demo -- seata分布式事务demo
│ │ ├─sharding-jdbc-demo -- sharding-jdbc分库分表demo
│ │ ├─rocketmq-demo -- rocketmq和mq事务demo
│ │ ├─sso-demo -- 单点登录demo
│ │ ├─websocket-demo -- websocket demo
```

## 7. 分支说明

| 分支名    | JDK | Spring Boot | Spring Cloud | Spring Security             |
|--------|-----|-------------|--------------|-----------------------------|
| master | 17  | 3.x         | 2022.x       | Spring Authorization Server |
| 2.x    | 1.8 | 2.5.x       | 2020.x       | Spring Security OAuth       |
| 1.x    | 1.8 | 2.3.x       | 2.2.x        | Spring Security OAuth       |

### 8. 其他资源

### 9. 环境依赖

- JDK 1.8 以上

- IDE 请安装对应IDE的 lombok 插件

- nodejs 16以上

### 10. 服务部署表格

| 服务名称 | 英文名	                       | 端口号	        | 版本号     | 服务类别 |
|------|----------------------------|-------------|---------|------|
| 数据库  | mysql                      | 3306        | v8      | 环境依赖 |
| 缓存	  | redis                      | 6379        | v6      | 环境依赖 |
| 消息队列 | rabbitmq                   | 5672, 15672 | v3.12.6 | 环境依赖 |
| 注册中心 | nacos                      | 8848        | v2.2.0  | 环境依赖 |
| 网关服务 | gateway	                   | 8101        | java 8  | 业务服务 |
| 用户服务 | jarvis-cloud-auth-server   | 8102        | java 8  | 业务服务 |
| 搜索服务 | jarvis-cloud-search-server | 8103        | java 8  | 业务服务 |

## 二 环境搭建

### 1. nacos安装

在一般项目中，常用的安装方式是通过官方下载安装包安装。这种方式比较简单，方便，并且可以在各种环境中快速部署Nacos服务。通常只需下载安装包，解压并配置一些参数，即可启动Nacos服务，适合多数情况下的项目使用。如果项目使用Docker或Kubernetes等容器技术，也可以考虑使用基于容器的安装方式。源码编译方式一般不太推荐，除非有特殊需求或定制化需求。

