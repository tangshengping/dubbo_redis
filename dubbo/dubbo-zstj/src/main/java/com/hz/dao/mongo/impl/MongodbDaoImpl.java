package com.hz.dao.mongo.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

import com.hz.dao.mongo.IMongodbDao;

@Repository("mongodbDao")
public class MongodbDaoImpl implements IMongodbDao {

    @Autowired
    private MongoTemplate mongoTemplate;

}
