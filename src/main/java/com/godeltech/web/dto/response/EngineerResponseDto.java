package com.godeltech.web.dto.response;

import lombok.Data;

@Data
public class EngineerResponseDto {
    private final Long id;
    private final String name;
    private final Integer flightsNumber;
    private final String speciality;
}
