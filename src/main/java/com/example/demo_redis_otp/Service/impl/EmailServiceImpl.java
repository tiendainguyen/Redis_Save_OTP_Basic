package com.example.demo_redis_otp.Service.impl;

import com.example.demo_redis_otp.Service.EmailService;
import com.example.demo_redis_otp.constant.EmailConstant;
import com.example.demo_redis_otp.exception.InternalServerError;
import lombok.extern.slf4j.Slf4j;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Async;
import org.thymeleaf.context.Context;
import org.thymeleaf.spring5.SpringTemplateEngine;

import javax.mail.Message;
import java.util.Map;

@Slf4j
public class EmailServiceImpl implements EmailService {
    private final JavaMailSender emailSender;
    private final SpringTemplateEngine templateEngine;
    private final String emailFrom;
    public EmailServiceImpl(JavaMailSender emailSender, SpringTemplateEngine templateEngine, String emailFrom) {
        this.emailSender = emailSender;
        this.templateEngine = templateEngine;
        this.emailFrom = emailFrom;
    }

    @Async
    @Override
    public void send(String subject, String to, String template, Map<String, Object> properties) {
        log.info("(send)subject: {}, to: {}, template: {}, properties: {}", subject, to, template, properties);
        try {
            var message = emailSender.createMimeMessage();
            message.setRecipients(Message.RecipientType.TO, to);
            message.setSubject(subject);
            message.setContent(getContent(template, properties), EmailConstant.CONTENT_TYPE_TEXT_HTML);
            emailSender.send(message);
        } catch (Exception ex) {
            log.info("(send)subject: {}, to: {}, ex: {} ", subject, to, ex.getMessage());
            throw new InternalServerError("Send mail failed to email: {}" + to);
        }
    }
    private String getContent(String template, Map<String, Object> properties) {
        var context = new Context();
        context.setVariables(properties);
        return templateEngine.process(template, context);
    }
}
