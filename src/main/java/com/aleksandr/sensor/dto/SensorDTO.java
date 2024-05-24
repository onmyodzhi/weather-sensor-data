package com.aleksandr.sensor.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Getter
@Setter
public class SensorDTO {


    @NotBlank(message = "Filed name should not be empty")
    @Size(min = 3, max = 30, message = "Field name should be between 3 to 30 characters")
    private String name;
}
