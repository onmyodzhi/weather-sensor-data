package com.aleksandr.sensor.controllers.handlers;

import com.aleksandr.sensor.until.SensorAlreadyExistException;
import com.aleksandr.sensor.until.SensorErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class SensorExceptionHandler {

    @ExceptionHandler(SensorAlreadyExistException.class)
    public ResponseEntity<SensorErrorResponse> handleSensorAlreadyExistException(SensorAlreadyExistException e) {
        SensorErrorResponse response = new SensorErrorResponse(e.getMessage());
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

}
