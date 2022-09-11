package com.ioco.survivalhelper.domain.services;

import com.ioco.survivalhelper.domain.dto.Survivor;
import com.ioco.survivalhelper.domain.dto.SurvivorReport;
import com.ioco.survivalhelper.domain.ports.in.SurvivorHandlerPort;
import com.ioco.survivalhelper.domain.ports.out.SurvivorPersistencePort;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

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
        survivorPersistencePort.saveSurvivors(survivors);
    }

    @Override
    public List<Survivor> getSurvivors(Boolean infected) {
        return survivorPersistencePort.getSurvivors(infected);
    }

    @Override
    public void updateLocation(UUID survivorId, double lat, double lon) {
        survivorPersistencePort.updateLocation(survivorId, lat, lon);
    }

    @Override
    public void updateIsInfected(UUID survivorId, boolean isInfected) {
        survivorPersistencePort.updateIsInfected(survivorId, isInfected);
    }

    @Override
    public SurvivorReport getSurvivorReport() {
        return survivorPersistencePort.getReport();
    }

}
