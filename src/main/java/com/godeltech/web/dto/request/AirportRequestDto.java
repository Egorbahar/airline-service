package com.godeltech.web.dto.request;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class AirportRequestDto {
    @NotBlank(message = "The code is required.")
    private String code;
    @NotNull(message = "The visibility is required.")
    private Integer visibility;
}
