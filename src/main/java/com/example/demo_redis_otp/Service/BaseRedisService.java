package com.example.demo_redis_otp.Service;

public interface BaseRedisService <T>{
    void delete(String key);

    Object get(String key);

    void set(String key, T object);
}
