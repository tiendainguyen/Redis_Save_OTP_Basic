package com.example.demo_redis_otp.Service;

import com.example.demo_redis_otp.request.AuthUserRegisterRequest;
import com.example.demo_redis_otp.response.AuthUserRegisterResponse;

public interface AuthFacadeService {
    AuthUserRegisterResponse register(AuthUserRegisterRequest request);

}
