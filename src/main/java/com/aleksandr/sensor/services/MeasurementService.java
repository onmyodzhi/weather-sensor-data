package com.aleksandr.sensor.services;

import com.aleksandr.sensor.dto.MeasurementDTO;
import com.aleksandr.sensor.dto.mapping.MeasurementMapping;
import com.aleksandr.sensor.model.Measurement;
import com.aleksandr.sensor.repositories.MeasurementRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor(onConstructor_ = {@Autowired})
public class MeasurementService {

    private final MeasurementRepository measurementRepository;

    private final MeasurementMapping measurementMapping;

    @Transactional
    public void save(MeasurementDTO measurementDTO) {
        Measurement measurement = measurementMapping.convertToMeasurement(measurementDTO);

        measurement.setTimeToFix(LocalDateTime.now());

        measurementRepository.save(measurement);
    }
}
