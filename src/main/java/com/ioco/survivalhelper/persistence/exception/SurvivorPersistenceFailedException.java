package com.ioco.survivalhelper.persistence.exception;

import org.springframework.http.HttpStatus;

/**
 * @author Lakith Dharmarathna
 * Date : 12/09/2022
 */
public class SurvivorPersistenceFailedException extends RuntimeException {

    private final HttpStatus httpStatus;

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    public SurvivorPersistenceFailedException(String message, HttpStatus httpStatus) {
        super(message);
        this.httpStatus = httpStatus;
    }
}
