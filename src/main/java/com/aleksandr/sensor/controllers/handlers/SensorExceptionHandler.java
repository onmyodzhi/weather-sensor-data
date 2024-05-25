package com.aleksandr.sensor.controllers.handlers;

import com.aleksandr.sensor.until.BadRequestException;
import com.aleksandr.sensor.until.SensorErrorResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@Slf4j
public class SensorExceptionHandler {
    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<SensorErrorResponse> handleSensorAlreadyExistException(BadRequestException e) {
        SensorErrorResponse response = new SensorErrorResponse(e.getMessage());
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }
}
