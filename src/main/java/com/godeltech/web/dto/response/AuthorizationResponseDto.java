package com.godeltech.web.dto.response;

import lombok.Data;

@Data
public class AuthorizationResponseDto {
    private final String token;
    //private final String refreshToken;
    private final String role;
    private final Long userId;
}