package com.godeltech.web.dto.response;

import lombok.Data;

@Data
public class UserResponseDto {
    private final Long id;
    private final String username;
    private final String password;
    private final Long roleId;
}
