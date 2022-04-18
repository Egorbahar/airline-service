package com.godeltech.web.dto.request;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class FlightProgressStatusRequestDto {
    @NotBlank(message = "{progress_status.name.notBlank}")
    private String name;
}
