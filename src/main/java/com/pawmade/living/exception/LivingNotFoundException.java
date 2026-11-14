package com.pawmade.living.exception;

public class LivingNotFoundException extends RuntimeException {
    public LivingNotFoundException(Long id) {
        super("Living " + id + " not found");
    }
}
