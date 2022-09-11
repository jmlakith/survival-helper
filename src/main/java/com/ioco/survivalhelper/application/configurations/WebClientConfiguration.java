package com.ioco.survivalhelper.application.configurations;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

/**
 * @author Lakith Dharmarathna
 * Date : 08/02/2022
 */
@Configuration
public class WebClientConfiguration {

    @Value("${robot.cpu.base-url}")
    private String robotListProviderUrl;
    @Value("${robot.cpu.get-list-uri}")
    private String getRobotListUri;

    @Bean
    public WebClient robotWebClient() {
        return WebClient.builder().baseUrl(robotListProviderUrl).build();
    }

    @Bean
    public String getRobotListUri() {
        return getRobotListUri;
    }
}
