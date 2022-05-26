package com.godeltech.web.dto.request;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class RoleRequestDto {
    @NotBlank(message = "{role.name.notBlank}")
    private final String name;
}
