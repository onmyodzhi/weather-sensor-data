package com.aleksandr.sensor.until;

public class SensorNameIsEmptyException extends RuntimeException{
    public SensorNameIsEmptyException(String message) {
        super(message);
    }
}
