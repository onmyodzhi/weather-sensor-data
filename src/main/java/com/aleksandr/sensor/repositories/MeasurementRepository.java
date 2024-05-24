package com.aleksandr.sensor.repositories;

import com.aleksandr.sensor.model.Measurement;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MeasurementRepository extends JpaRepository<Measurement, Long> {
}
