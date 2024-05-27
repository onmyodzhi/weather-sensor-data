package com.aleksandr.sensor.util;

public abstract class BadRequestException extends RuntimeException{
    public BadRequestException(String message) {
        super(message);
    }
}
