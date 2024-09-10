
package com.ari.hms.config.exception;

import com.ari.hms.config.exception.model.ValidationError;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class ApiException extends RuntimeException {

    @SuppressWarnings("checkstyle:JavadocVariable")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss")
    protected LocalDateTime timestamp;
    protected HttpStatus status;
    protected String message;

    protected List<ValidationError> validationErrors;

    private ApiException() {
        timestamp = LocalDateTime.now();
    }

    public ApiException(String message) {
        this();
        this.message = message;
    }
}
