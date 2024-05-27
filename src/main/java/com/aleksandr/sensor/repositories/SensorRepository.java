package com.aleksandr.sensor.repositories;

import com.aleksandr.sensor.dto.SensorDTO;
import com.aleksandr.sensor.model.Sensor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SensorRepository extends JpaRepository<Sensor, Long> {
    boolean existsSensorByName(String name);
    Sensor getSensorByName(String name);
}
