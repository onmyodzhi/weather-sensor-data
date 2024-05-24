package com.aleksandr.sensor.controllers.implementation;

import com.aleksandr.sensor.controllers.SensorController;
import com.aleksandr.sensor.dto.SensorDTO;
import com.aleksandr.sensor.services.SensorService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/sensors")
@RequiredArgsConstructor(onConstructor_ = {@Autowired})
public class SensorControllerImpl implements SensorController {

    private final SensorService sensorService;

    @Override
    public ResponseEntity<HttpStatus> addSensor(@RequestBody @Valid SensorDTO sensorDTO) {
        sensorService.save(sensorDTO);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
