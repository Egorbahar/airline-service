package com.godeltech.web.dto.request;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class UserRequestDto {
    @NotBlank(message = "{user.username.notBlank}")
    private final String username;
    @NotBlank(message = "{user.password.notBlank}")
    private final String password;
    @NotNull(message = "{user.roleId.notNull}")
    private final Long roleId;
}
