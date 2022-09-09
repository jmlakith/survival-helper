package com.ioco.survivalhelper.application.controllers;

import com.ioco.survivalhelper.application.dto.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Lakith Dharmarathna
 * Date : 09/09/2022
 */
@RestController
public class RobotsController {
    private static final String SUCCESS_MESSAGE = "Transaction Successful";

    @GetMapping("/robots")
    public ResponseEntity<ApiResponse> getRobotList() {
        return new ResponseEntity<>(ApiResponse.builder().responseCode(HttpStatus.OK.name()).message(SUCCESS_MESSAGE).data(null).build(), HttpStatus.OK);
    }
}
