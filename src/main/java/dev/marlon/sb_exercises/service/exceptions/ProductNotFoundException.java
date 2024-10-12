package dev.marlon.sb_exercises.service.exceptions;

public class ProductNotFoundException extends RuntimeException {

    public ProductNotFoundException(String message) {
        super(message);
    }
}
