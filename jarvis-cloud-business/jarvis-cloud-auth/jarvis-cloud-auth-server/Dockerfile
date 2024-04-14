# 基础镜像
FROM openjdk:8-jdk-alpine

# 指定工作目录
WORKDIR /app

# 将 jar 包添加到工作目录，比如 target/jarvis-cloud-auth-server.jar
ADD target/jarvis-cloud-auth-server.jar .

# 暴露端口
EXPOSE 8102

# 启动命令
ENTRYPOINT ["java","-jar","/app/jarvis-cloud-auth-server.jar","--spring.profiles.active=prod"]
