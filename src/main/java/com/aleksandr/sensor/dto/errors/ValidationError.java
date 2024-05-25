package com.aleksandr.sensor.dto.errors;

import lombok.Getter;

import java.util.List;
import java.util.Map;

/**
 * Данный класс предоставляет ошибку, которая будет отправлена клиенту в случае не успешной валидации
 */
@Getter
public class ValidationError extends AppError {
    private final Map<String, List<String>> errorDetails;

    /**
     * @param status       http status code
     * @param message      сообщение об ошибке
     * @param errorDetails детали ошибки, предоставляет из себя Map из имени поля/параметра, который не прошёл валидацию в список с текстами ошибок
     */
    public ValidationError(int status, String message, Map<String, List<String>> errorDetails) {
        super(status, message);
        this.errorDetails = errorDetails;
    }
}
