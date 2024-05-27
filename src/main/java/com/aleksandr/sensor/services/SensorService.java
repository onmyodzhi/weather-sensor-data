package com.aleksandr.sensor.services;

import com.aleksandr.sensor.dto.SensorDTO;
import com.aleksandr.sensor.model.Sensor;
import com.aleksandr.sensor.repositories.SensorRepository;
import com.aleksandr.sensor.util.SensorAlreadyExistException;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor(onConstructor_ = {@Autowired})
public class SensorService {

    private final SensorRepository sensorRepository;

    private final ModelMapper modelMapper;

    public Sensor convertToSensor(SensorDTO sensorDTO) {
        return modelMapper.map(sensorDTO, Sensor.class);
    }

    public SensorDTO convertToSensorDTO(Sensor sensor) {
        return modelMapper.map(sensor, SensorDTO.class);
    }

    @Transactional
    public void save(SensorDTO sensorDTO) {

        if (sensorExists(sensorDTO.getName())) {
            throw new SensorAlreadyExistException("Sensor with name " + sensorDTO.getName() + " already exists");
        }

        Sensor sensor = convertToSensor(sensorDTO);

        sensorRepository.save(sensor);
    }

    public Sensor getBySensorName(String name) {
        return sensorRepository.getSensorByName(name);
    }

    public boolean sensorExists(String sensorName) {
        return sensorRepository.existsSensorByName(sensorName);
    }

}
