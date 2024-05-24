package com.aleksandr.sensor.controllers;

import com.aleksandr.sensor.dto.SensorDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/sensors")
public interface SensorController {

    @PostMapping("/registration")
    ResponseEntity<HttpStatus> addSensor(@RequestBody @Valid SensorDTO sensorDTO);
}
