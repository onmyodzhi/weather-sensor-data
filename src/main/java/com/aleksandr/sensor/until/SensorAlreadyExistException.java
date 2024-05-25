package com.aleksandr.sensor.until;

public class SensorAlreadyExistException extends BadRequestException {
    public SensorAlreadyExistException(String message) {
        super(message);
    }
}
