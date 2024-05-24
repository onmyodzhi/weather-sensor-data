package com.aleksandr.sensor.services;

import com.aleksandr.sensor.dto.SensorDTO;
import com.aleksandr.sensor.dto.mapping.SensorMapping;
import com.aleksandr.sensor.model.Sensor;
import com.aleksandr.sensor.repositories.SensorRepository;
import com.aleksandr.sensor.until.SensorAlreadyExistException;
import com.aleksandr.sensor.until.SensorNameIsEmptyException;
import com.aleksandr.sensor.until.SensorNameIsLongException;
import com.aleksandr.sensor.until.SensorNameIsShortException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor(onConstructor_ = {@Autowired})
public class SensorService {

    private final SensorRepository sensorRepository;

    private final SensorMapping sensorMapping;

    @Transactional
    public void save(SensorDTO sensorDTO) {

        nameIsValid(sensorDTO.getName());

        Sensor sensor = sensorMapping.convertToSensor(sensorDTO);

        sensorRepository.save(sensor);
    }

    public void nameIsValid(String name) {

        if (name == null || name.trim().isEmpty()) {
            throw new SensorNameIsEmptyException("Sensor name is empty or consists of only empty characters");
        }

        name = name.trim();

        if (sensorExists(name)) {
            throw new SensorAlreadyExistException("Sensor with name " + name + " already exists");
        }
        if (name.length() <= 3) {
            throw new SensorNameIsShortException("Sensor name should have at least 3 characters");
        }
        if (name.length() >= 30) {
            throw new SensorNameIsLongException("Sensor name should have at most 30 characters");
        }
    }

    public boolean sensorExists(String sensorName) {
        return sensorRepository.existsSensorByName(sensorName);
    }


}
