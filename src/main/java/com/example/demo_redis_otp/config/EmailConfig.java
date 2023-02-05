package com.example.demo_redis_otp.config;

import com.example.demo_redis_otp.Service.EmailService;
import com.example.demo_redis_otp.Service.impl.EmailServiceImpl;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.thymeleaf.spring5.SpringTemplateEngine;

@Configuration
public class EmailConfig {
    @Value("${application.email.from}")
    private String emailFrom;

    @Bean
    public EmailService emailService(JavaMailSender emailSender, SpringTemplateEngine templateEngine) {
        return new EmailServiceImpl(emailSender, templateEngine, emailFrom);
    }
}
