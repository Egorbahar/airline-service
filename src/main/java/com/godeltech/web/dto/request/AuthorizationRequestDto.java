package com.godeltech.web.dto.request;

import lombok.Data;

import javax.validation.constraints.NotBlank;
@Data
public class AuthorizationRequestDto {
    @NotBlank
    private String username;
    @NotBlank
    private String password;
}
