package com.godeltech.persistence.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Component
@Getter
@Setter
public class Weather {
    @JsonProperty("speedWind")
    private Double speedWind;
    @JsonProperty("visibility")
    private Integer visibility;
}