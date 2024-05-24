package com.aleksandr.sensor.until;

public class SensorAlreadyExistException extends RuntimeException {

    public SensorAlreadyExistException() {
        super("Sensor already exists");
    }

    public SensorAlreadyExistException(String message) {
        super(message);
    }
}
