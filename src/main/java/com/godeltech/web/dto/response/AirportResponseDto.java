package com.godeltech.web.dto.response;

import lombok.Data;

@Data
public class AirportResponseDto {
    private final Long id;
    private final String code;
    private String cityName;
    private Integer visibility;
}
