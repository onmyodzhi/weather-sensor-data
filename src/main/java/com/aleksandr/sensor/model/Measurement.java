package com.aleksandr.sensor.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Entity
@Table(name = "Measurement")
@Getter
@Setter
@NoArgsConstructor
public class Measurement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "value")
    @Min(value = -99)
    @Max(value = 99)
    @NotNull
    private Double value;

    @Column(name = "raining")
    @NotNull
    private Boolean raining;

    @Column(name = "time_to_fix")
    @NotNull
    private LocalDateTime timeToFix;

    @NotNull
    @OneToOne
    @JoinColumn(name = "sensor_id")
    private Sensor sensorId;
}
