package com.lcc.ssm.service;

import com.lcc.ssm.entity.User;

import java.util.List;
import java.util.Set;

/**
 * Created by liangchengcheng on 2017/6/12.
 */
public interface JedisClient {

    String get(String key);

    String set(String key, String value);

    String hget(String hkey, String key);

    long hset(String hkey, String key, String value);

    long incr(String key);

    long expire(String key, int second);

    long ttl(String key);

    long del(String key);

    long hdel(String hkey, String key);

    long zadd(String key, double score, User user);

    Set<String> zgetAll(String key, long start, long end);

    //拿整个榜单
    long zaddList(String key, List<User> userList);

    //拿去榜单最后一名，比如前50名，这里就拿到第50名的User。积分变化时就拿这个值去判断，大于就丢user进redis，小于则不管
    Set<String> getTopLast(String key, long start, long end);
}
