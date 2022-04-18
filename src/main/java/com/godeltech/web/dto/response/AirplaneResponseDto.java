package com.godeltech.web.dto.response;

import lombok.Data;

@Data
public class AirplaneResponseDto {
    private final Long id;
    private final String name;
    private final Double windSpeed;
    private final Long categoryId;
}
