package com.godeltech.web.dto.response;

import lombok.Data;

@Data
public class AirplaneResponseDto {
    private Long id;
    private String name;
    private Double windSpeed;
    private Long categoryId;
}
