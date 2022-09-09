package com.ioco.survivalhelper.persistence.adapters;

import com.ioco.survivalhelper.domain.dto.Survivor;
import com.ioco.survivalhelper.domain.dto.SurvivorResources;
import com.ioco.survivalhelper.domain.ports.out.SurvivorPersistencePort;
import com.ioco.survivalhelper.persistence.entities.ResourcesEntity;
import com.ioco.survivalhelper.persistence.entities.SurvivorEntity;
import com.ioco.survivalhelper.persistence.mapper.SurvivorMapper;
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
        survivorRepository.saveAll(SurvivorMapper.dtoToEntityTransformation(records));
        log.info("Records saved successfully");
    }

    @Override
    public List<Survivor> getSurvivors(boolean infected) {

        return SurvivorMapper.entityToDtoTransformation(survivorRepository.findByIsInfected(infected));
    }


}
