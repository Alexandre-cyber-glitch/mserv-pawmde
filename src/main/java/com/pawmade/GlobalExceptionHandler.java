package com.pawmade;

import com.pawmade.living.exception.LivingNotFoundException;
import com.pawmade.living.exception.LivingTypeMismatchException;
import com.pawmade.photo.exception.InvalidPhotoException;
import com.pawmade.photo.exception.PhotoNotFoundException;
import com.pawmade.photo.exception.StorageException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.multipart.MaxUploadSizeExceededException;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(LivingNotFoundException.class)
    public ProblemDetail handleNotFound(LivingNotFoundException ex) {
        return ProblemDetail.forStatusAndDetail(HttpStatus.NOT_FOUND, ex.getMessage());
    }

    @ExceptionHandler(LivingTypeMismatchException.class)
    public ProblemDetail handleTypeMismatch(LivingTypeMismatchException ex) {
        return ProblemDetail.forStatusAndDetail(HttpStatus.BAD_REQUEST, ex.getMessage());
    }

    @ExceptionHandler(PhotoNotFoundException.class)
    public ProblemDetail handlePhotoNotFound(PhotoNotFoundException ex) {
        return ProblemDetail.forStatusAndDetail(HttpStatus.NOT_FOUND, ex.getMessage());
    }

    @ExceptionHandler(StorageException.class)
    public ProblemDetail handleStorage(StorageException ex) {
        return ProblemDetail.forStatusAndDetail(HttpStatus.INTERNAL_SERVER_ERROR, ex.getMessage());
    }

    @ExceptionHandler(InvalidPhotoException.class)
    public ProblemDetail handleInvalidPhoto(InvalidPhotoException ex) {
        return ProblemDetail.forStatusAndDetail(HttpStatus.BAD_REQUEST, ex.getMessage());
    }

    @ExceptionHandler(MaxUploadSizeExceededException.class)
    public ProblemDetail handleTooLarge(MaxUploadSizeExceededException ex) {
        return ProblemDetail.forStatusAndDetail(HttpStatus.CONTENT_TOO_LARGE, "File too large (max 10 MB)");
    }
}
