package com.godeltech.web.dto.request;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@Data
public class CaptainRequestDto {
    @NotBlank(message = "{captain.name.notBlank}")
    private String name;
    @NotNull(message = "{captain.flights.notNull}")
    @Positive(message = "{captain.flights.positive}")
    private Integer flightsNumber;
    @NotBlank(message = "{captain.rank.notBlank}")
    private String rank;
}
