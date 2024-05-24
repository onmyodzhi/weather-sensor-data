package com.aleksandr.sensor.dto.mapping;

import com.aleksandr.sensor.dto.SensorDTO;
import com.aleksandr.sensor.model.Sensor;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor(onConstructor_ = {@Autowired})
public class SensorMapping {

    private final ModelMapper modelMapper;

    public Sensor convertToSensor(SensorDTO sensorDTO) {
        return modelMapper.map(sensorDTO, Sensor.class);
    }
}
