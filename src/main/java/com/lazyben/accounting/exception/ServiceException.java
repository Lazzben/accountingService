package com.lazyben.accounting.exception;

import lombok.Data;

@Data
public class ServiceException extends RuntimeException {
    private int statusCode;
    private ServiceException.ErrorType errorType;
    private String code;

    public enum ErrorType {
        Client,
        Service,
        Unknown
    }

    public ServiceException(String message) {
        super(message);
    }

}
