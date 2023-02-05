package com.example.demo_redis_otp.Service.impl;

import com.example.demo_redis_otp.Service.AuthFacadeService;
import com.example.demo_redis_otp.Service.EmailService;
import com.example.demo_redis_otp.Service.OTPService;
import com.example.demo_redis_otp.constant.MailConstant;
import com.example.demo_redis_otp.request.AuthUserRegisterRequest;
import com.example.demo_redis_otp.response.AuthUserRegisterResponse;
import com.example.demo_redis_otp.utils.GeneratorUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;

import java.util.HashMap;

@Slf4j
public class AuthFacadeServiceImpl implements AuthFacadeService {
    @Value("${application.authentication.redis.otp_time_out}")
    private Integer otpTimeLife;
    private final OTPService otpService;
    private final EmailService emailService;

    public AuthFacadeServiceImpl(OTPService otpService, EmailService emailService) {
        this.otpService = otpService;
        this.emailService = emailService;
    }

    @Override
    public AuthUserRegisterResponse register(AuthUserRegisterRequest request) {
        log.info("(register)request: {}", request);
        //email: daint.dev@gmail.com
        // generate otp and push it to redis
        var otpActiveAccount = GeneratorUtils.generateOtp();
        otpService.set(request.getEmail(), otpActiveAccount);
        // Send mail request active account
        sendMailOTPTemplate(
                request.getEmail(),
                otpActiveAccount,
                MailConstant.MailRegister.KEY_PARAM_OTP_TIME_LIFE,
                MailConstant.MailRegister.KEY_PARAM_OTP,
                MailConstant.MailRegister.SUBJECT);


        return AuthUserRegisterResponse.of(
                "id1",
                "daint.dev@gmail.com",
                "id2",
                "daint",
                true);
    }
    private void sendMailOTPTemplate(
            String email, String otp, String keyParamTimeLife, String keyParamOtp, String subject) {
        log.info(
                "(sendMailOTPTemplate)email: {}, otp: {}, keyParamTimeLife: {}, keyParamOtp: {}, subject: {}",
                email,
                otp,
                keyParamTimeLife,
                keyParamOtp,
                subject);
        var params = new HashMap<String, Object>();
        params.put(keyParamTimeLife, otpTimeLife);
        params.put(keyParamOtp, otp);
        emailService.send(subject, email, MailConstant.OTP_TEMPLATE_NAME, params);
    }
}
