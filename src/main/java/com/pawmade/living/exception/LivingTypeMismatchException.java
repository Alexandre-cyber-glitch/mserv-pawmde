package com.pawmade.living.exception;

import com.pawmade.living.constant.Type;

public class LivingTypeMismatchException extends RuntimeException {
    public LivingTypeMismatchException(Long id, Type actual) {
        super("Living " + id + " is a " + actual + ", request type does not match");
    }
}
