package com.tucker.gmall.service;

public interface RedisService {
    void set(String key,Object value);

    void set(String key ,Object value , int seconds);

    void del(String key);

    Object get(String key);
}
