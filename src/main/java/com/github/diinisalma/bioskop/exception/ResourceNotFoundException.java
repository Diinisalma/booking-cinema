package com.github.diinisalma.bioskop.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.io.Serial;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException{

    @Serial
    private static final long serialVersionUID = -8606835631067579080L;

    public ResourceNotFoundException(String message) {
        super(message);
    }
}
