package com.ioco.survivalhelper.persistence.adapters;

import com.ioco.survivalhelper.domain.dto.Survivor;
import com.ioco.survivalhelper.domain.ports.out.SurvivorPersistencePort;
import com.ioco.survivalhelper.persistence.entities.ResourcesEntity;
import com.ioco.survivalhelper.persistence.entities.SurvivorEntity;
import com.ioco.survivalhelper.persistence.repositories.SurvivorRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Lakith Dharmarathna
 * Date : 09/09/2022
 */
@AllArgsConstructor
@Slf4j
@Component
public class SurvivorPersistenceAdapter implements SurvivorPersistencePort {

    private SurvivorRepository survivorRepository;

    @Override
    public void saveSurvivors(List<Survivor> records) {

        log.info("Records requested to save");
        survivorRepository.saveAll(getTransformedSurvivors(records));
        log.info("Records saved successfully");
    }

    private List<SurvivorEntity> getTransformedSurvivors(List<Survivor> survivors) {

        return survivors.stream().map(survivor -> SurvivorEntity.builder()
                .id(survivor.getId())
                .name(survivor.getName())
                .age(survivor.getAge())
                .isInfected(survivor.isInfected())
                .lat(survivor.getLat())
                .lon(survivor.getLon())
                .resources(survivor.getInventory().stream().map(resource -> ResourcesEntity.builder()
                        .item(resource.getItem())
                        .comment(resource.getComment())
                        .build()).collect(Collectors.toList()))
                .build()).collect(Collectors.toList());
    }
}
