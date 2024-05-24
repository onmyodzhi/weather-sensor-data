package com.aleksandr.sensor.until;

public class SensorAlreadyExistException extends RuntimeException {
    public SensorAlreadyExistException(String message) {
        super(message);
    }
}
