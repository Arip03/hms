package com.ari.hms.config.exception.exceptions;

import com.ari.hms.config.exception.ApiException;
import org.springframework.http.HttpStatus;

public class NotFoundException extends ApiException {

    public NotFoundException(String message) {
        super(message);
        this.status = HttpStatus.NOT_FOUND;
    }
}
