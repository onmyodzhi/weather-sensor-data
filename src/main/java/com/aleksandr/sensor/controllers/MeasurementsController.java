package com.aleksandr.sensor.controllers;

import com.aleksandr.sensor.dto.MeasurementDTO;
import com.aleksandr.sensor.dto.SensorDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/measurements")
public interface MeasurementsController {

    @GetMapping
    ResponseEntity<List<MeasurementDTO>> getAllMeasurements();

    @PostMapping("/add")
    ResponseEntity<HttpStatus> addMeasurement(@RequestBody @Valid MeasurementDTO measurementDTO);

    @GetMapping("/rainyDaysCount")
    ResponseEntity<List<MeasurementDTO>> getRainyDaysCount();
}
