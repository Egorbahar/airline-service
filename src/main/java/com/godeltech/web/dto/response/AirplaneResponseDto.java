package com.godeltech.web.dto.response;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import lombok.Data;

@Data
@JacksonXmlRootElement(localName = "Airplane")
public class AirplaneResponseDto {
    private final Long id;
    private final String name;
    private final Double windSpeed;
    private final Long categoryId;
    private final String categoryName;
}
