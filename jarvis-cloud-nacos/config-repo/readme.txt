配置文件说明：
/config-repo
    application.yml      # 是所有服务的全局配置
    application-dev.yml  # 是所有服务开发环境的全局配置
    application-prod.yml # 是所有服务正式环境的全局配置
    application-test.yml # 是所有服务测试环境的全局配置
    jarvis-cloud-xxx-server  # 是jarvis-xxx-server服务配置目录
        application.yml       # 是jarvis-xxx-server服务的全局配置
        application-dev.yml   # 是jarvis-xxx-server服务开发环境的全局配置
        application-prod.yml  # 是jarvis-xxx-server服务正式环境的全局配置
        application-test.yml  # 是jarvis-xxx-server服务测试环境的全局配置
