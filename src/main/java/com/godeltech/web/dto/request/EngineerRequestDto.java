package com.godeltech.web.dto.request;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@Data
public class EngineerRequestDto {
    @NotBlank(message = "{engineer.name.notBlank}")
    private String name;
    @NotNull(message = "{engineer.flights.notNull}")
    @Positive(message = "{engineer.flights.positive}")
    private Integer flightsNumber;
    @NotBlank(message = "{engineer.speciality.notBlank}")
    private String speciality;
}
