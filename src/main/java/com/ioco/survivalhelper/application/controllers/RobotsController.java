package com.ioco.survivalhelper.application.controllers;

import com.ioco.survivalhelper.domain.dto.Robot;
import com.ioco.survivalhelper.domain.enums.RobotType;
import com.ioco.survivalhelper.domain.ports.in.RobotHandlerPort;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

/**
 * @author Lakith Dharmarathna
 * Date : 09/09/2022
 */
@AllArgsConstructor
@RestController
public class RobotsController {
    private static final String SUCCESS_MESSAGE = "Transaction Successful";

    private RobotHandlerPort robotHandlerPort;

    @GetMapping("/robots")
    public Flux<Robot> getRobotList(@RequestParam(required = false) RobotType category) {

        return robotHandlerPort.getRobots(category);

    }
}
