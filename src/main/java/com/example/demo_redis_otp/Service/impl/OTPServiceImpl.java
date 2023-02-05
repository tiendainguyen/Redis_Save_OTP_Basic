package com.example.demo_redis_otp.Service.impl;

import com.example.demo_redis_otp.Service.EmailService;
import com.example.demo_redis_otp.Service.OTPService;

import java.util.concurrent.TimeUnit;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.RedisTemplate;

@Slf4j
public class OTPServiceImpl extends BaseRedisServiceImpl<String> implements OTPService{



    public OTPServiceImpl(RedisTemplate<String, Object> redisTemplate, long timeOut, TimeUnit unitTimeOut) {
        super(redisTemplate, timeOut, unitTimeOut);
    }

    @Override
    protected boolean isSavePersistent() {
        return false;
    }

}
