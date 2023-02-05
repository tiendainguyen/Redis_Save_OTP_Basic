package com.example.demo_redis_otp.config;

import com.example.demo_redis_otp.Service.AuthFacadeService;
import com.example.demo_redis_otp.Service.EmailService;
import com.example.demo_redis_otp.Service.OTPService;
import com.example.demo_redis_otp.Service.impl.AuthFacadeServiceImpl;
import com.example.demo_redis_otp.Service.impl.OTPServiceImpl;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.core.RedisTemplate;

import java.util.concurrent.TimeUnit;

@Configuration
public class AuthConfig {
    @Value("${application.authentication.redis.otp_time_out:3}")
    private Integer redisOtpTimeOut;
    @Bean
    public OTPService otpService(RedisTemplate<String, Object> redisTemplate) {
        return new OTPServiceImpl(redisTemplate, redisOtpTimeOut, TimeUnit.MINUTES);
    }
    @Bean
    public AuthFacadeService authFacadeService(
            EmailService emailService, OTPService otpService) {
        return new AuthFacadeServiceImpl(
                otpService,
                emailService);
    }
}
