package com.ioco.survivalhelper.domain.ports.out;

import com.ioco.survivalhelper.domain.dto.Robot;
import reactor.core.publisher.Flux;

/**
 * @author Lakith Dharmarathna
 * Date : 10/09/2022
 */
public interface RobotCpuAdapterPort {

    Flux<Robot> getRobotList();
}
