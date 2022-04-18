package com.godeltech.web.dto.request;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@Data
public class SecondPilotRequestDto {
    @NotBlank(message = "{secondPilot.name.notBlank}")
    private String name;
    @NotNull(message = "{secondPilot.flights.notNull}")
    @Positive(message = "{secondPilot.flights.positive}")
    private Integer flightsNumber;
    @NotBlank(message = "{secondPilot.rank.notBlank}")
    private String rank;
}
