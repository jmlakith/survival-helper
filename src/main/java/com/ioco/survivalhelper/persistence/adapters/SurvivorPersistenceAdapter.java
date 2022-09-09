package com.ioco.survivalhelper.persistence.adapters;

import com.ioco.survivalhelper.domain.dto.Survivor;
import com.ioco.survivalhelper.domain.dto.response.SurvivorReport;
import com.ioco.survivalhelper.domain.ports.out.SurvivorPersistencePort;
import com.ioco.survivalhelper.persistence.entities.SurvivorEntity;
import com.ioco.survivalhelper.persistence.exception.SurvivorNotAvailableException;
import com.ioco.survivalhelper.persistence.mapper.SurvivorMapper;
import com.ioco.survivalhelper.persistence.repositories.SurvivorRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * @author Lakith Dharmarathna
 * Date : 09/09/2022
 */
@AllArgsConstructor
@Slf4j
@Component
public class SurvivorPersistenceAdapter implements SurvivorPersistencePort {

    private static final String SURVIVOR_UNAVAILABILITY_MESSAGE = "Survivor not available";
    private SurvivorRepository survivorRepository;

    @Override
    public void saveSurvivors(List<Survivor> records) {

        survivorRepository.saveAll(SurvivorMapper.dtoToEntityTransformation(records));
        log.info("Records saved successfully");
    }

    @Override
    public List<Survivor> getSurvivors(Boolean infected) {

        if (infected != null) {
            return SurvivorMapper.entityToDtoTransformation(survivorRepository.findByIsInfected(infected));
        } else {
            return SurvivorMapper.entityToDtoTransformation(survivorRepository.findAll());
        }
    }

    @Override
    public void updateLocation(UUID survivorId, double lat, double lon) {

        Optional<SurvivorEntity> survivor = survivorRepository.findById(survivorId.toString());
        if (survivor.isPresent()) {
            SurvivorEntity survivorRecord = survivor.get();
            survivorRecord.setLon(lat);
            survivorRecord.setLon(lon);
            survivorRepository.save(survivorRecord);
        } else {
            log.error(SURVIVOR_UNAVAILABILITY_MESSAGE);
            throw new SurvivorNotAvailableException(SURVIVOR_UNAVAILABILITY_MESSAGE);
        }

    }

    @Override
    public void updateIsInfected(UUID survivorId, boolean isInfected) {

        Optional<SurvivorEntity> survivor = survivorRepository.findById(survivorId.toString());
        if (survivor.isPresent()) {
            SurvivorEntity survivorRecord = survivor.get();
            survivorRecord.setInfected(isInfected);
            survivorRepository.save(survivorRecord);
        } else {
            log.error(SURVIVOR_UNAVAILABILITY_MESSAGE);
            throw new SurvivorNotAvailableException(SURVIVOR_UNAVAILABILITY_MESSAGE);
        }

    }

    @Override
    public SurvivorReport getReport() {

        List<Survivor> infectedSurvivors = getSurvivors(true);
        List<Survivor> nonInfectedSurvivors = getSurvivors(false);
        double total = (double) infectedSurvivors.size() + nonInfectedSurvivors.size();
        double infectedSurvivorPercentage = (infectedSurvivors.size() * 100) / total;
        double nonInfectedSurvivorPercentage = (nonInfectedSurvivors.size() * 100) / total;

        return SurvivorReport.builder()
                .infectedPercentage(infectedSurvivorPercentage)
                .nonInfectedPercentage(nonInfectedSurvivorPercentage)
                .infectedSurvivors(infectedSurvivors)
                .infectedSurvivors(getSurvivors(true))
                .nonInfectedSurvivors(getSurvivors(false))
                .build();
    }


}
