package com.aleksandr.sensor.until;

public abstract class BadRequestException extends RuntimeException{
    public BadRequestException(String message) {
        super(message);
    }
}
