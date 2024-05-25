package com.aleksandr.sensor.services;

import com.aleksandr.sensor.dto.SensorDTO;
import com.aleksandr.sensor.dto.mapping.SensorMapping;
import com.aleksandr.sensor.model.Sensor;
import com.aleksandr.sensor.repositories.SensorRepository;
import com.aleksandr.sensor.until.SensorAlreadyExistException;
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

        if (sensorExists(sensorDTO.getName())) {
            throw new SensorAlreadyExistException("Sensor with name " + sensorDTO.getName() + " already exists");
        }

        Sensor sensor = sensorMapping.convertToSensor(sensorDTO);

        sensorRepository.save(sensor);
    }

    public boolean sensorExists(String sensorName) {
        return sensorRepository.existsSensorByName(sensorName);
    }


}
