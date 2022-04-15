package com.godeltech.web.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class WeatherDto {
    @JsonProperty("speedWind")
    @NotNull
    private Double speedWind;
    @JsonProperty("visibility")
    @NotNull
    private Integer visibility;
}
