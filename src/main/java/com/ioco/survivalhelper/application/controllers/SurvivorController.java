package com.ioco.survivalhelper.application.controllers;

import com.ioco.survivalhelper.application.dto.request.AddSurvivorsRequestBody;
import com.ioco.survivalhelper.application.dto.ApiResponse;
import com.ioco.survivalhelper.application.dto.request.CheckInfectedRequestBody;
import com.ioco.survivalhelper.application.dto.request.UpdateLocationRequestBody;
import com.ioco.survivalhelper.application.dto.response.SurvivorInventoryResponse;
import com.ioco.survivalhelper.application.dto.response.SurvivorsResponseBody;
import com.ioco.survivalhelper.application.mappers.SurvivorRequestMapper;
import com.ioco.survivalhelper.domain.dto.Survivor;
import com.ioco.survivalhelper.domain.dto.SurvivorResources;
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

    private static final String SUCCESS_MESSAGE = "Request Successful";

    private SurvivorHandlerPort survivorHandler;

    @PostMapping()
    public ResponseEntity<ApiResponse> addSurvivors(@RequestBody AddSurvivorsRequestBody request) {

        log.info("Request body received for 'addSurvivors' : {}", request);
        List<Survivor> newSurvivors = SurvivorRequestMapper.requestBodyToDtoTransform(request);
        survivorHandler.addSurvivors(newSurvivors);

        return new ResponseEntity<>(ApiResponse.builder()
                .responseCode(HttpStatus.OK.name())
                .message(SUCCESS_MESSAGE)
                .data(null).build(), HttpStatus.OK);
    }

    @GetMapping()
    public ResponseEntity<ApiResponse> getSurvivors(@RequestParam(required = false) Boolean infected) {

        log.info("Request received for 'getSurvivors' : {}", infected);
        return new ResponseEntity<>(ApiResponse.builder()
                .responseCode(HttpStatus.OK.name())
                .message(SUCCESS_MESSAGE)
                .data(SurvivorRequestMapper.dtoToResponseBodyTransform(survivorHandler.getSurvivors(infected)))
                .build(), HttpStatus.OK);
    }

    @PatchMapping("/{survivorId}/location")
    public ResponseEntity<ApiResponse> updateLocation(@PathVariable UUID survivorId, @RequestBody UpdateLocationRequestBody request) {

        survivorHandler.updateLocation(survivorId, request.getLat(), request.getLon());
        return new ResponseEntity<>(ApiResponse.builder()
                .responseCode(HttpStatus.OK.name())
                .message(SUCCESS_MESSAGE)
                .data(null).build(), HttpStatus.OK);
    }

    @PatchMapping("/{survivorId}/health")
    public ResponseEntity<ApiResponse> updateIsInfected(@PathVariable UUID survivorId, @RequestBody CheckInfectedRequestBody request) {

        survivorHandler.updateIsInfected(survivorId, request.getIsInfected());
        return new ResponseEntity<>(ApiResponse.builder()
                .responseCode(HttpStatus.OK.name())
                .message(SUCCESS_MESSAGE)
                .data(null).build(), HttpStatus.OK);
    }

    @GetMapping("/report")
    public ResponseEntity<ApiResponse> getSurvivorReport() {

        return new ResponseEntity<>(ApiResponse.builder()
                .responseCode(HttpStatus.OK.name())
                .message(SUCCESS_MESSAGE)
                .data(null).build(), HttpStatus.OK);
    }

}
