package com.hz.dao.redis;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public interface IRedisDao {

    /**
     * 是否存在该键值得数据值
     * @param key
     * @return
     */
    public Boolean isExisitValue(String key);

    /**
     * 添加一个（String key , String value）字符串类型的数据
     * @param key
     * @param value
     * @return
     */
    public Boolean setString(String key,String value);

    /**
     * 添加一个带有缓存时间的字符串数据
     * @param key
     * @param value
     * @param time（时间长度）
     * @param timeUnit（时间类型）
     * @return
     */
    public Boolean setString(String key,String value,int time,TimeUnit timeUnit);

    /**
     * 从redis中删除string值
     * @param key
     * @return
     */
    public Boolean removeString(String key);

    /**
     * 从redis中获取数据
     * @param key
     * @return
     */
    public String getStringFormRedis(String key);

    /**
     * 保存对象到redis中
     * @param key
     * @param t
     * @param <T>
     */
    public <T> Boolean saveObj(String key,T t);

    /**
     * 保存对象到redis中
     * @param key
     * @param t
     * @param time
     * @param timeUnit
     */
    public <T> Boolean saveObj(String key,T t,int time,TimeUnit timeUnit);

    /**
     * 从redis中获取数据
     * @param key
     * @return
     */
    public <T> T getObj(String key);

    /**
     * 保存set集到redis
     * @param key
     * @param set
     * @param <T>
     * @return
     */
    public <T> Boolean setSet(String key,Set<T> set);

    /**
     * 保存set到redis中
     * @param key
     * @param set
     * @param time
     * @param timeUnit
     * @param <T>
     * @return
     */
    public <T> Boolean setSet(String key,Set<T> set,int time,TimeUnit timeUnit);

    /**
     * 从redis中获取set集合
     * @param key
     * @param <T>
     * @return
     */
    public <T> Set<T> getSet(String key);

    /**
     * 添加map集合到redis中
     * @param key
     * @param map
     * @param <K>
     * @param <Y>
     * @return
     */
    public <K,Y> Boolean setMap(String key, Map<K,Y> map);

    /**
     * 从redis中获取map转换为map结果集
     * @param key
     * @param <K>
     * @param <Y>
     * @return
     */
    public <K,Y> Map<K,Y> getMapToMap(String key);

    /**
     * 从redis中获取map转换为list结果集
     * @param key
     * @param <T>
     * @return
     */
    public <T> List<T> getMapToList(String key);

    /**
     * 从redis中获取map转换为set结果集
     * @param key
     * @param <T>
     * @return
     */
    public <T> Set<T> getMapToSet(String key);

    /**
     * 从redis中获取map指定key值对应的value值
     * @param mapKey
     * @param valueKey
     * @param <T>
     * @return
     */
    public <T> T getMapToString(String mapKey,String valueKey);

    /**
     * 添加list集合到redis中
     * @param key
     * @param <T>
     * @return
     */
    public <T> Boolean leftPush(String key,List<T> list);

    /**
     * 添加list集合到redis中
     * @param key
     * @param <T>
     * @return
     */
    public <T> Boolean rightPush(String key,List<T> list);

    /**
     * 从redis中获取list集合
     * @param key
     * @param <T>
     * @return
     */
    public <T> List<T> leftPop(String key);

    /**
     * 从redis中获取list集合
     * @param key
     * @param <T>
     * @return
     */
    public <T> List<T> rightPop(String key);

}
