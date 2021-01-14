package com.lazyben.accounting.exception;

import lombok.val;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(ServiceException.class)
    ResponseEntity<?> handleServiceException(ServiceException ex) {
        val errorResponse = ErrorResponse.builder()
                .errorType(ex.getErrorType())
                .code(ex.getCode())
                .message(ex.getMessage())
                .statusCode(ex.getStatusCode())
                .build();

        return ResponseEntity.status(ex.getStatusCode())
                .body(errorResponse);
    }
}
