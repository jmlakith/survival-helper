package com.ioco.survivalhelper.persistence.exception;

import org.springframework.http.HttpStatus;

/**
 * @author Lakith Dharmarathna
 * Date : 09/09/2022
 */
public class SurvivorNotAvailableException extends RuntimeException {

    private final HttpStatus httpStatus;

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    public SurvivorNotAvailableException(String message, HttpStatus httpStatus) {
        super(message);
        this.httpStatus = httpStatus;
    }



}
