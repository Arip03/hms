package com.ari.hms.config.exception.exceptions;

import com.ari.hms.config.exception.ApiException;
import org.springframework.http.HttpStatus;

public class ConflictException extends ApiException {

    public ConflictException(String message) {
        super(message);
        this.status = HttpStatus.CONFLICT;
    }
}
