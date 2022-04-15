package com.godeltech.web.dto.request;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;


@Data
public class CategoryRequestDto {
    @NotBlank(message = "The name is required.")
    private String name;
}
