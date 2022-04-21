package com.godeltech.web.dto.request;

import lombok.Data;

import javax.validation.constraints.NotBlank;
@Data
public class AuthorizationRequestDto {
    @NotBlank(message = "{authorization.username.notBlank}")
    private String username;
    @NotBlank(message = "{authorization.password.notBlank}")
    private String password;
}
