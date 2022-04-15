package com.godeltech.web.dto.request;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class AirplaneRequestDto {
    @NotBlank(message = "The name is required.")
    private String name;
    @NotNull(message = "The speed of wind is required.")
    private Double windSpeed;
    @NotNull(message = "The category is required.")
    private Long categoryId;
}
