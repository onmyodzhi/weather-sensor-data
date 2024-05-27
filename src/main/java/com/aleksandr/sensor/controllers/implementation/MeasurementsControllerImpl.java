package com.aleksandr.sensor.controllers.implementation;

import com.aleksandr.sensor.controllers.MeasurementsController;
import com.aleksandr.sensor.dto.MeasurementDTO;
import com.aleksandr.sensor.dto.SensorDTO;
import com.aleksandr.sensor.services.MeasurementService;
import com.aleksandr.sensor.services.SensorService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/measurements")
@RequiredArgsConstructor(onConstructor_ = {@Autowired})
public class MeasurementsControllerImpl implements MeasurementsController {

    private final MeasurementService measurementService;

    @Override
    public ResponseEntity<List<MeasurementDTO>> getAllMeasurements() {
        List<MeasurementDTO> measurementDTOList = measurementService.findAll();
        return new ResponseEntity<>(measurementDTOList, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<HttpStatus> addMeasurement(@RequestBody @Valid MeasurementDTO measurementDTO) {
        measurementService.save(measurementDTO);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @Override
    public ResponseEntity<List<MeasurementDTO>> getRainyDaysCount() {
        List<MeasurementDTO> rainingDays = measurementService.findAllRainingDays();
        return ResponseEntity.status(HttpStatus.OK).body(rainingDays);
    }
}
