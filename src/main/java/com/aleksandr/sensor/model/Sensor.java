package com.aleksandr.sensor.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table(name = "sensor")
@Getter
@Setter
@NoArgsConstructor
public class Sensor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    @NotBlank(message = "Filed name should not be empty")
    @Size(min = 3, max = 30, message = "Field name should be between 3 to 30 characters")
    private String name;

    @OneToOne(mappedBy = "sensor")
    private Measurement measurement;
}
