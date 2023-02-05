package com.example.demo_redis_otp.constant;

public class MailConstant {
    public static final String OTP_TEMPLATE_NAME = "OTP-template.html";
    public static class MailResetPassword {
    }

    public static class MailForgotPassword {
        public static final String SUBJECT = "OKRS: Forgot Password!";
        public static final String TEMPLATE_NAME = "OTP-template.html";
        public static final String KEY_PARAM_OTP_TIME_LIFE = "time_life";
        public static final String KEY_PARAM_OTP = "otp";
    }

    public static class MailRegister {
        public static final String SUBJECT = "OKRS: Register Account!";
        public static final String TEMPLATE_NAME = "OTP-template.html";
        public static final String KEY_PARAM_OTP_TIME_LIFE = "time_life";
        public static final String KEY_PARAM_OTP = "otp";
    }

    public static class MailUnlockAccount {
        public static final String SUBJECT = "OKRS: Unlock Account!";
        public static final String KEY_PARAM_OTP_TIME_LIFE = "time_life";
        public static final String KEY_PARAM_OTP = "otp";
    }
}

