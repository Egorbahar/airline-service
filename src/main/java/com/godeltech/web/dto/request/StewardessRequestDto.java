package com.godeltech.web.dto.request;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@Data
public class StewardessRequestDto {
    @NotBlank(message = "{stewardess.name.notBlank}")
    private String name;
    @NotNull(message = "{stewardess.flights.notNull}")
    @Positive(message = "{stewardess.flights.positive}")
    private Integer flightsNumber;
}
