package com.ioco.survivalhelper.domain.ports.in;


import com.ioco.survivalhelper.domain.dto.Robot;
import com.ioco.survivalhelper.domain.enums.RobotType;
import reactor.core.publisher.Flux;

/**
 * @author Lakith Dharmarathna
 * Date : 10/09/2022
 */
public interface RobotHandlerPort {

    Flux<Robot> getRobots(RobotType type);
}
