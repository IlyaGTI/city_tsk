package com.example.city_tsk.exception;

public class NotFoundException extends RuntimeException {

    public NotFoundException(String format, String message) {
        super(message);
    }

    public NotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

}