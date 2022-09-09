package com.ioco.survivalhelper.persistence.adapters;

import com.ioco.survivalhelper.domain.dto.SurvivorRecords;
import com.ioco.survivalhelper.domain.dto.SurvivorResourceRecords;
import com.ioco.survivalhelper.domain.dto.request.Survivor;
import com.ioco.survivalhelper.domain.ports.out.SurvivorPersistencePort;
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
    public void saveSurvivors(List<SurvivorRecords> records) {

        log.info("Records requested to save");
        survivorRepository.saveAll(getTransformedSurvivors(records));
        log.info("Records saved successfully");
    }

    private List<SurvivorEntity> getTransformedSurvivors(List<SurvivorRecords> survivors) {

        return survivors.stream().map(survivor -> SurvivorEntity.builder()
                .id(survivor.getId())
                .name(survivor.getName())
                .age(survivor.getAge())
                .isInfected(survivor.isInfected())
                .lat(survivor.getLat())
                .lon(survivor.getLon())
                .build()).collect(Collectors.toList());
    }
}
