package com.godeltech.web.dto.request;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class CaptainRequestDto {
    @NotBlank(message = "The name is required.")
    private String name;
    @NotNull
    private Integer flightsNumber;
    @NotBlank(message = "The rank is required")
    private String rank;
}
