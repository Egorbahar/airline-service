package com.godeltech.web.dto.response;

import lombok.Data;

@Data
public class StewardessResponseDto {
    private final Long id;
    private final String name;
    private final Integer flightsNumber;
}
