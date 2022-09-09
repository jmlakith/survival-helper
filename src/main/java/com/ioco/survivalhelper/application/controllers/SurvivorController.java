package com.ioco.survivalhelper.application.controllers;

import com.ioco.survivalhelper.application.dto.AddSurvivorsRequest;
import com.ioco.survivalhelper.application.dto.ApiResponse;
import com.ioco.survivalhelper.application.dto.CheckInfectedRequest;
import com.ioco.survivalhelper.application.dto.UpdateLocationRequest;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

/**
 * @author Lakith Dharmarathna
 * Date : 09/09/2022
 */
@Slf4j
@AllArgsConstructor
@RestController
@RequestMapping("/survivors")
public class SurvivorController {

    private static final String SUCCESS_MESSAGE = "Transaction Successful";

    @PostMapping()
    public ResponseEntity<ApiResponse> addSurvivors(@RequestBody AddSurvivorsRequest request) {

        return new ResponseEntity<>(ApiResponse.builder().responseCode(HttpStatus.OK.name()).message(SUCCESS_MESSAGE).data(request).build(), HttpStatus.OK);
    }

    @GetMapping()
    public ResponseEntity<ApiResponse> getSurvivors(@RequestParam(required = false) boolean infected) {

        return new ResponseEntity<>(ApiResponse.builder().responseCode(HttpStatus.OK.name()).message(SUCCESS_MESSAGE).data(null).build(), HttpStatus.OK);
    }

    @PatchMapping("/{survivorId}/location")
    public ResponseEntity<ApiResponse> updateLocation(@PathVariable UUID survivorId, @RequestBody UpdateLocationRequest request) {

        return new ResponseEntity<>(ApiResponse.builder().responseCode(HttpStatus.OK.name()).message(SUCCESS_MESSAGE).data(null).build(), HttpStatus.OK);
    }

    @PatchMapping("/{survivorId}/health")
    public ResponseEntity<ApiResponse> updateIsInfected(@PathVariable UUID survivorId, @RequestBody CheckInfectedRequest request) {

        return new ResponseEntity<>(ApiResponse.builder().responseCode(HttpStatus.OK.name()).message(SUCCESS_MESSAGE).data(null).build(), HttpStatus.OK);
    }

    @GetMapping("/report")
    public ResponseEntity<ApiResponse> getSurvivorReport() {

        return new ResponseEntity<>(ApiResponse.builder().responseCode(HttpStatus.OK.name()).message(SUCCESS_MESSAGE).data(null).build(), HttpStatus.OK);
    }
}
