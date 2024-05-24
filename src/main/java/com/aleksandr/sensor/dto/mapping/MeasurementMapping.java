package com.aleksandr.sensor.dto.mapping;

import com.aleksandr.sensor.dto.MeasurementDTO;
import com.aleksandr.sensor.model.Measurement;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor(onConstructor_ = {@Autowired})
public class MeasurementMapping {

    private final ModelMapper modelMapper;

    public Measurement convertToMeasurement(MeasurementDTO measurementDTO) {
        return modelMapper.map(measurementDTO, Measurement.class);
    }
}
