package com.ioco.survivalhelper.application.controllers;

import com.ioco.survivalhelper.application.dto.ApiResponse;
import com.ioco.survivalhelper.application.dto.request.AddSurvivorsRequestBody;
import com.ioco.survivalhelper.application.dto.request.CheckInfectedRequestBody;
import com.ioco.survivalhelper.application.dto.request.UpdateLocationRequestBody;
import com.ioco.survivalhelper.application.mappers.SurvivorRequestMapper;
import com.ioco.survivalhelper.domain.dto.Survivor;
import com.ioco.survivalhelper.domain.dto.SurvivorReport;
import com.ioco.survivalhelper.domain.ports.in.SurvivorHandlerPort;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
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

    private static final String SUCCESS_MESSAGE = "Request Successful";

    private SurvivorHandlerPort survivorHandler;

    /**
     * This method can be used to save list of survivors to the database
     * @param request
     * @return
     */
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

    /**
     * This method will be used to fetch Survivors from the database
     * @param infected infected or not filter
     * @return
     */
    @GetMapping()
    public ResponseEntity<ApiResponse> getSurvivors(@RequestParam(required = false) Boolean infected) {

        log.info("Request received for 'getSurvivors' : {}", infected);
        return new ResponseEntity<>(ApiResponse.builder()
                .responseCode(HttpStatus.OK.name())
                .message(SUCCESS_MESSAGE)
                .data(SurvivorRequestMapper.dtoToResponseBodyTransform(survivorHandler.getSurvivors(infected)))
                .build(), HttpStatus.OK);
    }

    /**
     * This method will be used to update the location of a survivor
     * @param survivorId Unique id of the survivor
     * @param request
     * @return
     */
    @PatchMapping("/{survivorId}/location")
    public ResponseEntity<ApiResponse> updateLocation(@PathVariable UUID survivorId, @RequestBody UpdateLocationRequestBody request) {

        log.info("Request received for 'updateLocation' : {}", request);
        survivorHandler.updateLocation(survivorId, request.getLat(), request.getLon());
        return new ResponseEntity<>(ApiResponse.builder()
                .responseCode(HttpStatus.OK.name())
                .message(SUCCESS_MESSAGE)
                .data(null).build(), HttpStatus.OK);
    }

    /**
     * This method will be used to update whether the survivor is infected with the virus
     * @param survivorId Unique id of the survivor
     * @param request
     * @return
     */
    @PatchMapping("/{survivorId}/health")
    public ResponseEntity<ApiResponse> updateIsInfected(@PathVariable UUID survivorId, @RequestBody CheckInfectedRequestBody request) {

        log.info("Request received for 'updateIsInfected' : {}", request);
        survivorHandler.updateIsInfected(survivorId, request.getIsInfected());
        return new ResponseEntity<>(ApiResponse.builder()
                .responseCode(HttpStatus.OK.name())
                .message(SUCCESS_MESSAGE)
                .data(null).build(), HttpStatus.OK);
    }

    /**
     * This method will generate a report consist of all infected vs non-infected statistics
     * @return
     */
    @GetMapping("/report")
    public ResponseEntity<ApiResponse> getSurvivorReport() {

        log.info("Request received for 'getSurvivorReport'");
        SurvivorReport report = survivorHandler.getSurvivorReport();
        log.info("Response 'getSurvivorReport'");

        return new ResponseEntity<>(ApiResponse.builder()
                .responseCode(HttpStatus.OK.name())
                .message(SUCCESS_MESSAGE)
                .data(report).build(), HttpStatus.OK);
    }

}
