package com.godeltech.exception;

public class NotUniqueUserException extends RuntimeException {
    public NotUniqueUserException(String message) {
        super(message);
    }
}
