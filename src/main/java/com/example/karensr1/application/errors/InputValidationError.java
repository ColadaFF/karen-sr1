package com.example.karensr1.application.errors;

public class InputValidationError extends RuntimeException {
    private final String message;

    public InputValidationError(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
