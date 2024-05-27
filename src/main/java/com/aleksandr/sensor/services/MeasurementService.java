package com.aleksandr.sensor.services;

import com.aleksandr.sensor.dto.MeasurementDTO;
import com.aleksandr.sensor.model.Measurement;
import com.aleksandr.sensor.model.Sensor;
import com.aleksandr.sensor.repositories.MeasurementRepository;
import com.aleksandr.sensor.util.SensorIsNotExistsException;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor(onConstructor_ = {@Autowired})
public class MeasurementService {

    private final MeasurementRepository measurementRepository;

    private final SensorService sensorService;

    private final ModelMapper modelMapper;

    public Measurement convertToMeasurement(MeasurementDTO measurementDTO) {
        return modelMapper.map(measurementDTO, Measurement.class);
    }

    public MeasurementDTO convertToMeasurementDTO(Measurement measurement) {
        return modelMapper.map(measurement, MeasurementDTO.class);
    }

    @Transactional
    public void save(MeasurementDTO measurementDTO) {
        Measurement measurement = convertToMeasurement(measurementDTO);

        if (!sensorService.sensorExists(measurement.getSensor().getName())) {
            throw new SensorIsNotExistsException("Sensor " + measurement.getSensor().getName() + " not exists");
        }

        Sensor sensor = sensorService.getBySensorName(measurement.getSensor().getName());

        measurement.setSensor(sensor);
        measurement.setTimeToFix(LocalDateTime.now());

        measurementRepository.save(measurement);
    }

    public List<MeasurementDTO> findAllRainingDays(){
        return measurementRepository.findByRainingIsTrue().stream()
                .map(this::convertToMeasurementDTO)
                .collect(Collectors.toList());
    }

    public List<MeasurementDTO> findAll() {
        return measurementRepository.findAll().stream()
                .map(this::convertToMeasurementDTO).collect(Collectors.toList());
    }
}
