package com.ioco.survivalhelper.application.controllers;

import com.ioco.survivalhelper.application.dto.AddSurvivorsRequestBody;
import com.ioco.survivalhelper.application.dto.ApiResponse;
import com.ioco.survivalhelper.application.dto.CheckInfectedRequestBody;
import com.ioco.survivalhelper.application.dto.UpdateLocationRequestBody;
import com.ioco.survivalhelper.domain.dto.request.Survivor;
import com.ioco.survivalhelper.domain.dto.request.SurvivorResources;
import com.ioco.survivalhelper.domain.ports.in.SurvivorHandlerPort;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

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

    private SurvivorHandlerPort survivorHandler;

    @PostMapping()
    public ResponseEntity<ApiResponse> addSurvivors(@RequestBody AddSurvivorsRequestBody request) {

        log.info("Request body received for 'addSurvivors' : {}", request);
        List<Survivor> newSurvivors = getTransformedSurvivors(request);
        survivorHandler.addSurvivors(newSurvivors);

        return new ResponseEntity<>(ApiResponse.builder().responseCode(HttpStatus.OK.name()).message(SUCCESS_MESSAGE).data(request).build(), HttpStatus.OK);
    }

    private List<Survivor> getTransformedSurvivors(AddSurvivorsRequestBody request) {

        return request.getSurvivors().stream().map(survivor -> Survivor.builder()
                .id(survivor.getId())
                .name(survivor.getName())
                .age(survivor.getAge())
                .isInfected(survivor.isInfected())
                .lat(survivor.getLat())
                .lon(survivor.getLon())
                .inventory(survivor.getInventory().stream().map(resource -> SurvivorResources.builder()
                        .item(resource.getItem())
                        .comment(resource.getComment())
                        .build()).collect(Collectors.toList()))
                .build()).collect(Collectors.toList());

    }

    @GetMapping()
    public ResponseEntity<ApiResponse> getSurvivors(@RequestParam(required = false) boolean infected) {

        return new ResponseEntity<>(ApiResponse.builder().responseCode(HttpStatus.OK.name()).message(SUCCESS_MESSAGE).data(null).build(), HttpStatus.OK);
    }

    @PatchMapping("/{survivorId}/location")
    public ResponseEntity<ApiResponse> updateLocation(@PathVariable UUID survivorId, @RequestBody UpdateLocationRequestBody request) {

        return new ResponseEntity<>(ApiResponse.builder().responseCode(HttpStatus.OK.name()).message(SUCCESS_MESSAGE).data(null).build(), HttpStatus.OK);
    }

    @PatchMapping("/{survivorId}/health")
    public ResponseEntity<ApiResponse> updateIsInfected(@PathVariable UUID survivorId, @RequestBody CheckInfectedRequestBody request) {

        return new ResponseEntity<>(ApiResponse.builder().responseCode(HttpStatus.OK.name()).message(SUCCESS_MESSAGE).data(null).build(), HttpStatus.OK);
    }

    @GetMapping("/report")
    public ResponseEntity<ApiResponse> getSurvivorReport() {

        return new ResponseEntity<>(ApiResponse.builder().responseCode(HttpStatus.OK.name()).message(SUCCESS_MESSAGE).data(null).build(), HttpStatus.OK);
    }
}
