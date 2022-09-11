package com.ioco.survivalhelper.persistence.adapters;

import com.ioco.survivalhelper.domain.dto.Survivor;
import com.ioco.survivalhelper.domain.ports.out.SurvivorPersistencePort;
import com.ioco.survivalhelper.persistence.entities.SurvivorEntity;
import com.ioco.survivalhelper.persistence.exception.SurvivorNotAvailableException;
import com.ioco.survivalhelper.persistence.exception.SurvivorPersistenceFailedException;
import com.ioco.survivalhelper.persistence.mapper.SurvivorMapper;
import com.ioco.survivalhelper.persistence.repositories.SurvivorRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
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

        try {
            survivorRepository.saveAll(SurvivorMapper.dtoToEntityTransformation(records));
        } catch (Exception ex) {
            log.error("Encountered an error while persisting the data", ex);
            throw new SurvivorPersistenceFailedException("Failed to persist the survivor data",
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
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

        try {
            Optional<SurvivorEntity> survivor = survivorRepository.findById(survivorId.toString());
            if (survivor.isPresent()) {
                SurvivorEntity survivorRecord = survivor.get();
                survivorRecord.setLon(lat);
                survivorRecord.setLon(lon);
                survivorRepository.save(survivorRecord);
            } else {
                log.error(SURVIVOR_UNAVAILABILITY_MESSAGE);
                throw new SurvivorNotAvailableException(SURVIVOR_UNAVAILABILITY_MESSAGE, HttpStatus.PRECONDITION_FAILED);
            }
        } catch (Exception ex) {
            log.error("Encountered an error while updating the location", ex);
            throw new SurvivorPersistenceFailedException("Failed to update the survivor location",
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @Override
    public void updateIsInfected(UUID survivorId, boolean isInfected) {

        try {
            Optional<SurvivorEntity> survivor = survivorRepository.findById(survivorId.toString());
            if (survivor.isPresent()) {
                SurvivorEntity survivorRecord = survivor.get();
                survivorRecord.setInfected(isInfected);
                survivorRepository.save(survivorRecord);
            } else {
                log.error(SURVIVOR_UNAVAILABILITY_MESSAGE);
                throw new SurvivorNotAvailableException(SURVIVOR_UNAVAILABILITY_MESSAGE, HttpStatus.PRECONDITION_FAILED);
            }
        } catch (Exception ex) {
            log.error("Encountered an error while updating the is infected", ex);
            throw new SurvivorPersistenceFailedException("Failed to update the infected status",
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

}
