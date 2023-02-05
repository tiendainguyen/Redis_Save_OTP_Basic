package com.example.demo_redis_otp.Controller;

import com.example.demo_redis_otp.Service.AuthFacadeService;
import com.example.demo_redis_otp.Service.impl.RedisExample;
import com.example.demo_redis_otp.request.AuthUserRegisterRequest;
import com.example.demo_redis_otp.response.AuthResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/api/v1/auth/users")
@RestController
@Slf4j
public class AuthController {
    private final AuthFacadeService authFacadeService;
    private final RedisExample redisExample;
    public AuthController(AuthFacadeService authFacadeService, RedisExample redisExample) {
        this.authFacadeService = authFacadeService;
        this.redisExample = redisExample;
    }

    @PostMapping("/register")
    @ResponseStatus(HttpStatus.CREATED)
    public AuthResponse register(@RequestBody AuthUserRegisterRequest request) {
        log.info("(createUser)request: {}", request);
        return AuthResponse.of(HttpStatus.CREATED.value(), authFacadeService.register(request));
    }
    @GetMapping("/getOTP")
    public AuthResponse getOTP(@RequestParam String email){
        log.info("(OTP)is: {}", redisExample.valueExample(email));
        return AuthResponse.of(HttpStatus.CREATED.value(), redisExample.valueExample(email));
    };
}