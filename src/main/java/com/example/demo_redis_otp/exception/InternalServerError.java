package com.example.demo_redis_otp.exception;

public class InternalServerError extends BaseException {
    public InternalServerError() {
        setStatus(500);
        setCode("org.ptit.okrs.core_exception.InternalServerError");
    }

    public InternalServerError(String message) {
        setStatus(500);
        setMessage(message);
    }
}

