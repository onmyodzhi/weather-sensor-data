package com.aleksandr.sensor.controllers.handlers;

import com.aleksandr.sensor.dto.errors.ValidationError;
import lombok.extern.slf4j.Slf4j;
import lombok.var;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.ElementKind;
import javax.validation.Path;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestControllerAdvice
@Slf4j
public class ValidationExceptionHandler {
    @ExceptionHandler({ConstraintViolationException.class})
    public ResponseEntity<?> processConstraintViolationException(ConstraintViolationException processedException) {
        Map<String, List<String>> errorsDescriptions = new HashMap<>();
        List<ConstraintViolation<?>> unprocessedViolations = new ArrayList<>();
        for (var constraintViolation : processedException.getConstraintViolations()) {
            if (constraintViolation.getRootBeanClass().isAnnotationPresent(RestController.class)) {
                for (Path.Node node : constraintViolation.getPropertyPath()) {
                    if (node.getKind() == ElementKind.PARAMETER) {
                        errorsDescriptions.computeIfAbsent(node.getName(), k -> new ArrayList<>()).add(constraintViolation.getMessage());
                    }
                }
            } else unprocessedViolations.add(constraintViolation);
        }
        if (!unprocessedViolations.isEmpty())
            log.error("Unprocessed constrain violation detected: {}", unprocessedViolations);
        return ResponseEntity.badRequest().body(new ValidationError(HttpStatus.BAD_REQUEST.value(), "Validation error", errorsDescriptions));
    }
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> processMethodArgumentNotValidException(MethodArgumentNotValidException processedException){
        BindingResult bindingResult = processedException.getBindingResult();
        Map<String, List<String>> fieldErrors = new HashMap<>();
        for (FieldError fieldError : bindingResult.getFieldErrors()) {
            fieldErrors.computeIfAbsent(fieldError.getField(), (key)->new ArrayList<>()).add(fieldError.getDefaultMessage());
        }
        return new ResponseEntity<>(new ValidationError(HttpStatus.BAD_REQUEST.value(),
                "Validation error", fieldErrors), HttpStatus.BAD_REQUEST);
    }
}
