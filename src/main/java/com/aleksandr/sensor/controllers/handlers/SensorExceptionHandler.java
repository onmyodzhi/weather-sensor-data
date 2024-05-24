package com.aleksandr.sensor.controllers.handlers;

import com.aleksandr.sensor.until.*;
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

    @ExceptionHandler(SensorNameIsShortException.class)
    public ResponseEntity<SensorErrorResponse> handleSensorNameIsShortException(SensorNameIsShortException e) {
        SensorErrorResponse response = new SensorErrorResponse(e.getMessage());
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(SensorNameIsLongException.class)
    public ResponseEntity<SensorErrorResponse> handleSensorNameIsLongException(SensorNameIsLongException e) {
        SensorErrorResponse response = new SensorErrorResponse(e.getMessage());
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(SensorNameIsEmptyException.class)
    public ResponseEntity<SensorErrorResponse> handleSensorNameIsEmptyException(SensorNameIsEmptyException e) {
        SensorErrorResponse response = new SensorErrorResponse(e.getMessage());
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }
}
