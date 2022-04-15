package com.godeltech.web.dto.request;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class StewardessRequestDto {
    @NotBlank(message = "The name is required.")
    private String name;
    @NotNull
    private Integer flightsNumber;
}
