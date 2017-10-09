package com.hz.dao.redis.impl;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Repository;

import com.hz.dao.redis.IRedisDao;

@Repository("redisDao")
public class RedisDaoImpl implements IRedisDao{

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Autowired
    private RedisTemplate redisTemplate;

    @Override
    public Boolean isExisitValue(String key){
        return redisTemplate.hasKey(key);
    }

    @Override
    public Boolean setString(String key,String value){
         Boolean isSuccess = false;
         ValueOperations<String,String> operation = redisTemplate.opsForValue();
         try{
             operation.set(key, value);
             isSuccess = true;
         }catch (Exception e){
             e.printStackTrace();
         }
         return isSuccess;
    }

    @Override
    public Boolean setString(String key,String value,int time,TimeUnit timeUnit){
        Boolean isSuccess = false;
        ValueOperations<String,String> operation = redisTemplate.opsForValue();
        try{
            operation.set(key, value,time,timeUnit);
            isSuccess = true;
        }catch (Exception e){
            e.printStackTrace();
        }
        return isSuccess;
    }

    @Override
    public Boolean removeString(String key){
        Boolean isSuccess = false;
        boolean hasKey = redisTemplate.hasKey(key);
        if (!hasKey) {
            return null;
        }
        try{
            stringRedisTemplate.delete(key);
            isSuccess = true;
        }catch (Exception e){
            e.printStackTrace();
        }
        return isSuccess;
    }

    @Override
    public String getStringFormRedis(String key) {
        boolean hasKey = redisTemplate.hasKey(key);
        if (!hasKey) {
            return null;
        }
        return stringRedisTemplate.opsForValue().get(key);
    }

    @Override
    public <T> Boolean saveObj(String key,T t){
        Boolean isSuccess = false;
        try {
            redisTemplate.opsForValue().set(key,t);
            isSuccess = true;
        }catch (Exception e){
            e.printStackTrace();
        }
        return isSuccess;
    }

    @Override
    public <T> Boolean saveObj(String key,T t,int time,TimeUnit timeUnit){
        Boolean isSuccess = false;
        try {
            redisTemplate.opsForValue().set(key,t,time,timeUnit);
            isSuccess = true;
        }catch (Exception e){
            e.printStackTrace();
        }
        return isSuccess;
    }

    @Override
    public <T> T getObj(String key){
        boolean hasKey = redisTemplate.hasKey(key);
        if (!hasKey) {
            return null;
        }
        return (T) redisTemplate.opsForValue().get(key);
    }

    @Override
    public <T> Boolean setSet(String key,Set<T> set){
        Boolean isSuccess = false;
        try {
            redisTemplate.opsForSet().add(key,set);
            isSuccess = true;
        }catch (Exception e){
            e.printStackTrace();
        }
        return isSuccess;
    }

    @Override
    public <T> Boolean setSet(String key,Set<T> set,int time,TimeUnit timeUnit){
        Boolean isSuccess = false;
        try {
            redisTemplate.opsForSet().add(key,set,time,timeUnit);
            isSuccess = true;
        }catch (Exception e){
            e.printStackTrace();
        }
        return isSuccess;
    }

    @Override
    public <T> Set<T> getSet(String key){
        boolean hasKey = redisTemplate.hasKey(key);
        if (!hasKey) {
            return null;
        }
        return redisTemplate.opsForSet().members(key);
    }

    @Override
    public <K,Y> Boolean setMap(String key, Map<K,Y> map){
        Boolean isSuccess = false;
        try {
            redisTemplate.opsForHash().putAll(key,map);
            isSuccess = true;
        }catch (Exception e){
            e.printStackTrace();
        }
        return isSuccess;
    }

    @Override
    public <K,Y> Map<K,Y> getMapToMap(String key){
        boolean hasKey = redisTemplate.hasKey(key);
        if (!hasKey) {
            return null;
        }
        return redisTemplate.opsForHash().entries(key);
    }

    @Override
    public <T> List<T> getMapToList(String key){
        boolean hasKey = redisTemplate.hasKey(key);
        if (!hasKey) {
            return null;
        }
        return redisTemplate.opsForHash().values(key);
    }

    @Override
    public <T> Set<T> getMapToSet(String key){
        boolean hasKey = redisTemplate.hasKey(key);
        if (!hasKey) {
            return null;
        }
        return redisTemplate.opsForHash().keys(key);
    }

    @Override
    public <T> T getMapToString(String mapKey,String valueKey){
        boolean hasKey = redisTemplate.hasKey(mapKey);
        if (!hasKey) {
            return null;
        }
        return (T)redisTemplate.opsForHash().get(mapKey,valueKey);
    }

    @Override
    public <T> Boolean leftPush(String key,List<T> list){
        Boolean isSuccess = false;
        try {
            redisTemplate.opsForList().leftPush(key,list);
            isSuccess = true;
        }catch (Exception e){
            e.printStackTrace();
        }
        return isSuccess;
    }

    @Override
    public <T> Boolean rightPush(String key,List<T> list){
        Boolean isSuccess = false;
        try {
            redisTemplate.opsForList().leftPush(key,list);
            isSuccess = true;
        }catch (Exception e){
            e.printStackTrace();
        }
        return isSuccess;
    }

    @Override
    public <T> List<T> leftPop(String key){
        boolean hasKey = redisTemplate.hasKey(key);
        if (!hasKey) {
            return null;
        }
        return (List<T>)redisTemplate.opsForList().leftPop(key);
    }

    @Override
    public <T> List<T> rightPop(String key){
        boolean hasKey = redisTemplate.hasKey(key);
        if (!hasKey) {
            return null;
        }
        return (List<T>)redisTemplate.opsForList().leftPop(key);
    }

}
