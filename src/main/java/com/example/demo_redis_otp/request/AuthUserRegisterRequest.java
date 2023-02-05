package com.example.demo_redis_otp.request;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.Objects;

@Data
@NoArgsConstructor
@Slf4j
public class AuthUserRegisterRequest {
    private String email;

    private String username;


    private String password;

}

