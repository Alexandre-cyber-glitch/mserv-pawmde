package com.pawmade.photo.exception;

import java.util.UUID;

public class PhotoNotFoundException extends RuntimeException {

    public PhotoNotFoundException(UUID id) {
        super("Photo " + id + " not found");
    }

    public PhotoNotFoundException(String message) {
        super(message);
    }
}
