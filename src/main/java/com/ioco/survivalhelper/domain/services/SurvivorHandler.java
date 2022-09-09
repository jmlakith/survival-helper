package com.ioco.survivalhelper.domain.services;

import com.ioco.survivalhelper.domain.dto.SurvivorRecords;
import com.ioco.survivalhelper.domain.dto.SurvivorResourceRecords;
import com.ioco.survivalhelper.domain.dto.request.Survivor;
import com.ioco.survivalhelper.domain.ports.in.SurvivorHandlerPort;
import com.ioco.survivalhelper.domain.ports.out.SurvivorPersistencePort;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Lakith Dharmarathna
 * Date : 09/09/2022
 */
@Slf4j
@AllArgsConstructor
@Service
public class SurvivorHandler implements SurvivorHandlerPort {

    private SurvivorPersistencePort survivorPersistencePort;


    @Override
    public void addSurvivors(List<Survivor> survivors) {
        log.info("Survivors arrived service layer :{}", survivors);
        survivorPersistencePort.saveSurvivors(getTransformedSurvivors(survivors));
    }

    private List<SurvivorRecords> getTransformedSurvivors(List<Survivor> survivors) {

        return survivors.stream().map(survivor -> SurvivorRecords.builder()
                .id(survivor.getId())
                .name(survivor.getName())
                .age(survivor.getAge())
                .isInfected(survivor.isInfected())
                .lat(survivor.getLat())
                .lon(survivor.getLon())
                .inventory(survivor.getInventory().stream().map(resource -> SurvivorResourceRecords.builder()
                        .item(resource.getItem())
                        .comment(resource.getComment())
                        .build()).collect(Collectors.toList()))
                .build()).collect(Collectors.toList());

    }
}
