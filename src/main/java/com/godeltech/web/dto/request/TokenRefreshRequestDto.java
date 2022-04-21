package com.godeltech.web.dto.request;

import lombok.Data;

import javax.validation.constraints.NotBlank;
@Data
public class TokenRefreshRequestDto {
    @NotBlank(message = "{refresh.token.notBlank}")
    private String refreshToken;
}
