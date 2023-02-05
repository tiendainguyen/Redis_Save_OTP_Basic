package com.example.demo_redis_otp.Service;

import java.util.Map;

public interface EmailService {
    void send(String subject, String to, String template, Map<String, Object> properties);

    /**
     * Send mail file attach
     * @param subject - the subject of the email
     * @param to - the email address of the receiver
     * @param content - the body of the mail
     * @param fileToAttach - the path of the file need to attach
     */
}
