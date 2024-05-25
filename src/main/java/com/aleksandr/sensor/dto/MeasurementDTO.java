package com.aleksandr.sensor.dto;

import com.aleksandr.sensor.model.Sensor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.OneToOne;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Getter
@Setter
public class MeasurementDTO {

    @Min(value = -99)
    @Max(value = 99)
    @NotNull
    private Double value;

    @NotNull
    private Boolean raining;

    @NotNull
    @OneToOne
    private Sensor sensor;
}
