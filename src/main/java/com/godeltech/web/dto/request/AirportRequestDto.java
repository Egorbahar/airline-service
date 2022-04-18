package com.godeltech.web.dto.request;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@Data
public class AirportRequestDto {
    @NotBlank(message = "{airport.code.notBlank}")
    private String code;
    @NotNull(message = "{airport.visibility.notNull}")
    @Positive(message = "{airport.visibility.positive}")
    private Integer visibility;
}
