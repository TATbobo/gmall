package com.tucker.gmall.service.service.imp;

import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

@Service(version = "${manage.service.version}")
public class RedisService implements com.tucker.gmall.service.RedisService {

    @Resource(name = "redisTemplate")
    private RedisTemplate redisTemplate;

    @Override
    public void set(String key, Object value) {
        redisTemplate.opsForValue().set(key,value);
    }

    @Override
    public void set(String key, Object value, int seconds) {

        redisTemplate.
        redisTemplate.opsForValue().set(key,value,seconds, TimeUnit.SECONDS);
    }

    @Override
    public void del(String key) {
        redisTemplate.delete(key);
    }

    @Override
    public Object get(String key) {
        return redisTemplate.opsForValue().get(key);
    }
}
