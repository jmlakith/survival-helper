package com.ioco.survivalhelper.provider;

import com.ioco.survivalhelper.domain.dto.Robot;
import com.ioco.survivalhelper.domain.ports.out.RobotListAdapterPort;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;

/**
 * @author Lakith Dharmarathna
 * Date : 10/09/2022
 */
@Component
public class RobotListAdapter implements RobotListAdapterPort {

    private static final String ROBOT_LIST_PROVIDER_URL = "https://robotstakeover20210903110417.azurewebsites.net/robotcpu";

    @Override
    public Flux<Robot> getRobotList() {

        WebClient webClient = WebClient.create(ROBOT_LIST_PROVIDER_URL);

        return webClient.get()
                .retrieve()
                .bodyToFlux(Robot.class);

    }
}
