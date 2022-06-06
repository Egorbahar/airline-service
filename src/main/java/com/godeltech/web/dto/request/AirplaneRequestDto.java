package com.godeltech.web.dto.request;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class AirplaneRequestDto {
    @NotBlank(message = "{airplane.name.notBlank}")
    private final String name;
    @NotNull(message = "{airplane.wind.notNull}")
    private final Double windSpeed;
    @NotNull(message = "{airplane.categoryId.notNull}")
    private final Long categoryId;
}
