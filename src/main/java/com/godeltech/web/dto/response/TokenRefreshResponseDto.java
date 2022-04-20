package com.godeltech.web.dto.response;

import lombok.Data;

@Data
public class TokenRefreshResponseDto {
    private final String accessToken;
    private final String refreshToken;
    private final String tokenType = "Bearer";

    public TokenRefreshResponseDto(String accessToken, String refreshToken) {
        this.accessToken = accessToken;
        this.refreshToken = refreshToken;
    }
}
