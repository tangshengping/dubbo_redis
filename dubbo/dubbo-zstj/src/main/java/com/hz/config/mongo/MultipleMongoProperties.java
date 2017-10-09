package com.hz.config.mongo;

import org.springframework.boot.autoconfigure.mongo.MongoProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

/**
 * mongodb配置多数据源，从application.yml提取注入参数
 */
@Configuration
public class MultipleMongoProperties {

    @Bean(name="apiLogMongoProperties")
    @Primary
    @ConfigurationProperties(prefix="spring.data.mongodb.apiLog")
    public MongoProperties apiLogMongoProperties() {
        return new MongoProperties();
    }

    @Bean(name="mallMongoProperties")
    @ConfigurationProperties(prefix="spring.data.mongodb.mall")
    public MongoProperties mallMongoProperties() {
        return new MongoProperties();
    }

}
