package com.godeltech.web.dto.response;

import lombok.Data;

@Data
public class AuthorizationResponseDto {
    private String token;
    private String refreshToken;
    private String role;
    private Long userId;
}