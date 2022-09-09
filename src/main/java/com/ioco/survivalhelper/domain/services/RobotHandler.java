package com.ioco.survivalhelper.domain.services;

import com.ioco.survivalhelper.domain.dto.Robot;
import com.ioco.survivalhelper.domain.enums.RobotType;
import com.ioco.survivalhelper.domain.ports.in.RobotHandlerPort;
import com.ioco.survivalhelper.domain.ports.out.RobotListAdapterPort;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

/**
 * @author Lakith Dharmarathna
 * Date : 10/09/2022
 */
@AllArgsConstructor
@Service
public class RobotHandler implements RobotHandlerPort {

    private RobotListAdapterPort robotListAdapterPort;

    @Override
    public Flux<Robot> getRobots(RobotType type) {

        Flux<Robot> robots = robotListAdapterPort.getRobotList();
        if (type != null) {
            return robots.filter(val -> val.getCategory().equals(type));
        } else {
            return robots;
        }
    }

}
