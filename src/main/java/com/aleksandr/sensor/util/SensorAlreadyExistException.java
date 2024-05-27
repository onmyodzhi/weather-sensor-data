package com.aleksandr.sensor.util;

public class SensorAlreadyExistException extends BadRequestException {
    public SensorAlreadyExistException(String message) {
        super(message);
    }
}
