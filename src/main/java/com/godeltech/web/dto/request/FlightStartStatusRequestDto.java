package com.godeltech.web.dto.request;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class FlightStartStatusRequestDto {
    @NotBlank(message = "{start_status.name.notBlank}")
    private String name;
}
