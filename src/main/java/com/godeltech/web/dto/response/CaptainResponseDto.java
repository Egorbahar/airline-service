package com.godeltech.web.dto.response;

import lombok.Data;

@Data
public class CaptainResponseDto {
    private Long id;
    private String name;
    private Integer flightsNumber;
    private String rank;
}
