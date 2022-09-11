package com.ioco.survivalhelper.application.controllers;

import com.ioco.survivalhelper.application.dto.ApiResponse;
import com.ioco.survivalhelper.persistence.exception.SurvivorNotAvailableException;
import com.ioco.survivalhelper.persistence.exception.SurvivorPersistenceFailedException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

/**
 * @author Lakith Dharmarathna
 * Date : 12/09/2022
 */
@Slf4j
@ControllerAdvice
public class SurvivorExceptionHandler {

    @ExceptionHandler(value
            = {SurvivorNotAvailableException.class})
    public ResponseEntity<ApiResponse> survivorAvailabilityErrorHandling(
            SurvivorNotAvailableException ex, WebRequest request) {

        log.error("survivorAvailabilityErrorHandling: Encountered an error for the request: {}", request);

        return new ResponseEntity<>(ApiResponse.builder()
                .responseCode(ex.getHttpStatus().name())
                .message(ex.getMessage())
                .data(ex.getStackTrace()).build(), ex.getHttpStatus());
    }

    @ExceptionHandler(value
            = {SurvivorPersistenceFailedException.class})
    public ResponseEntity<ApiResponse> survivorPersistenceErrorHandling(
            SurvivorPersistenceFailedException ex, WebRequest request) {

        log.error("survivorPersistenceErrorHandling: Encountered an error for the request: {}", request);

        return new ResponseEntity<>(ApiResponse.builder()
                .responseCode(ex.getHttpStatus().name())
                .message(ex.getMessage())
                .data(ex.getStackTrace()).build(), ex.getHttpStatus());
    }


}
