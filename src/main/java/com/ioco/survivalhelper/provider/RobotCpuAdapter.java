
package com.ioco.survivalhelper.provider;

import com.ioco.survivalhelper.domain.dto.Robot;
import com.ioco.survivalhelper.domain.ports.out.RobotCpuAdapterPort;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.util.retry.Retry;

import java.time.Duration;

/**
 * @author Lakith Dharmarathna
 * Date : 10/09/2022
 */
@Slf4j
@AllArgsConstructor
@Component
public class RobotCpuAdapter implements RobotCpuAdapterPort {


    private final String getRobotListUri;
    private final WebClient robotWebClient;

    private static final Duration TIMEOUT_DURATION = Duration.ofMillis(10_100);
    private static final int MAX_ATTEMPTS = 2;
    private static final Duration BACKOFF_DURATION = Duration.ofSeconds(2);
    private static final Integer BACKPRESSURE = 10;


    @Override
    public Flux<Robot> getRobotList() {

        return robotWebClient.get()
                .uri(getRobotListUri)
                .retrieve()
                .bodyToFlux(Robot.class)
                .timeout(TIMEOUT_DURATION)
                .limitRate(BACKPRESSURE)
                .retryWhen(
                        Retry.backoff(MAX_ATTEMPTS, BACKOFF_DURATION)
                );
    }
}
