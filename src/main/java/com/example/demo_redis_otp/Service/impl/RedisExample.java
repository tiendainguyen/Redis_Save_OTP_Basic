package com.example.demo_redis_otp.Service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Primary;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class RedisExample {
    @Autowired
    @Qualifier("redisTemplate")
    private RedisTemplate template;

//    @Override
//    public void run(String... args) throws Exception {
//        valueExample();
//    }

    public Object valueExample(String email){
        // Set giá trị của key "loda" là "hello redis"
//        template.opsForValue().set("loda","hello world");

        // In ra màn hình Giá trị của key "loda" trong Redis
        System.out.println("Value of key: "+template.opsForValue().get(email));
        return template.opsForValue().get(email);
    }

    public void listExample(){
        // Tạo ra một list gồm 2 phần tử
        List<String> list = new ArrayList<>();
        list.add("Hello");
        list.add("redis");

        // Set gia trị có key loda_list
        template.opsForList().rightPushAll("loda_list", list);
//        template.opsForList().rightPushAll("loda_list", "hello", "world");

        System.out.println("Size of key loda: "+template.opsForList().size("loda_list"));
        // key là tên list trong redis, value là giá trị đẩy vào key list
    }
}
