package com.sg.SuperHero.service;

public class ValidationException extends RuntimeException {
    public ValidationException(String message) {
        super(message);
    }
}