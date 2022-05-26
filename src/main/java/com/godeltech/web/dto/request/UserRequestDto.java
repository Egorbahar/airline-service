package com.godeltech.web.dto.request;

import lombok.Data;
import org.hibernate.validator.constraints.UniqueElements;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
public class UserRequestDto {
    @NotBlank(message = "{user.username.notBlank}")
    private final String username;
    @NotBlank(message = "{user.password.notBlank}")
    @Size(min = 8, max = 30)
    private final String password;
    @NotNull(message = "{user.roleId.notNull}")
    private final Long roleId;
}
