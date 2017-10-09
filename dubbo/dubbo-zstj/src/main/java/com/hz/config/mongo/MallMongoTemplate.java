package com.hz.config.mongo;

import com.mongodb.MongoClient;
import com.mongodb.ServerAddress;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.mongo.MongoProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@Configuration
@EnableMongoRepositories(basePackages = "com.hz.bean.mongo.mall", mongoTemplateRef = "mallMongo")
public class MallMongoTemplate {

    @Autowired
    @Qualifier("mallMongoProperties")
    private MongoProperties mongoProperties;

    @Bean(name = "mallMongo")
    public MongoTemplate mallTemplate() throws Exception {
        return new MongoTemplate(mallFactory(this.mongoProperties));
    }

    @Bean
    public MongoDbFactory mallFactory(MongoProperties mongoProperties) throws Exception {
        ServerAddress serverAdress = new ServerAddress(mongoProperties.getUri());
        return new SimpleMongoDbFactory(new MongoClient(serverAdress), mongoProperties.getDatabase());
    }

}
