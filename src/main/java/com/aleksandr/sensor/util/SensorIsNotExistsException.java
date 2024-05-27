package com.aleksandr.sensor.util;

public class SensorIsNotExistsException extends BadRequestException{
    public SensorIsNotExistsException(String message) {
        super(message);
    }
}
