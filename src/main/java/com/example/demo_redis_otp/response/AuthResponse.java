package com.example.demo_redis_otp.response;

import com.example.demo_redis_otp.utils.DateUtils;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor(staticName = "of")
public class AuthResponse {
    private int status;
    private String timestamp;
    private Object data;

    public static AuthResponse of(int status, Object data) {
        return AuthResponse.of(status, DateUtils.getCurrentDateTimeStr(), data);
    }

    public static AuthResponse of(int status) {
        return AuthResponse.of(status, DateUtils.getCurrentDateTimeStr(), null);
    }
}

