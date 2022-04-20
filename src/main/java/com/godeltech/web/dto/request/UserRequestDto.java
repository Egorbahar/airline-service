package com.godeltech.web.dto.request;

import lombok.Data;

@Data
public class UserRequestDto {
    private final String username;
    private final String password;
    private final Long roleId;
}
