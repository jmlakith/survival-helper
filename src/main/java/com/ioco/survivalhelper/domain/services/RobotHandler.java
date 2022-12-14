package com.ioco.survivalhelper.domain.services;

import com.ioco.survivalhelper.domain.dto.Robot;
import com.ioco.survivalhelper.domain.enums.RobotType;
import com.ioco.survivalhelper.domain.ports.in.RobotHandlerPort;
import com.ioco.survivalhelper.domain.ports.out.RobotCpuAdapterPort;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

import java.util.Comparator;

/**
 * @author Lakith Dharmarathna
 * Date : 10/09/2022
 */
@AllArgsConstructor
@Service
public class RobotHandler implements RobotHandlerPort {

    private RobotCpuAdapterPort robotCpuAdapterPort;

    @Override
    public Flux<Robot> getRobots(RobotType type) {

        //Group by category for better readability
        Flux<Robot> robots = robotCpuAdapterPort.getRobotList().defaultIfEmpty(new Robot())
                .sort(Comparator.comparing(Robot::getCategory));

        if (type != null) {
            return robots.filter(val -> val.getCategory().equals(type));
        } else {
            return robots;
        }

    }

}
