package com.ari.hms.config.exception.exceptions;

import com.ari.hms.config.exception.ApiException;
import org.springframework.http.HttpStatus;

public class BadRequestException extends ApiException {

    public BadRequestException(String message) {
        super(message);
        this.status = HttpStatus.BAD_REQUEST;
    }
}

