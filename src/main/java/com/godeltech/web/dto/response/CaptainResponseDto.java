package com.godeltech.web.dto.response;

import lombok.Data;

@Data
public class CaptainResponseDto {
    private final Long id;
    private final String name;
    private final Integer flightsNumber;
    private final String rank;
}
