package com.lazyben.accounting.exception;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ErrorResponse {
    private String code;
    private String message;
    private int statusCode;
    private ServiceException.ErrorType errorType;
}
