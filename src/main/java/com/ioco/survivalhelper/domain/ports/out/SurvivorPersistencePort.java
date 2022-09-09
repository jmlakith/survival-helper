package com.ioco.survivalhelper.domain.ports.out;

import com.ioco.survivalhelper.domain.dto.Survivor;

import java.util.List;
import java.util.UUID;

/**
 * @author Lakith Dharmarathna
 * Date : 09/09/2022
 */
public interface SurvivorPersistencePort {
    void saveSurvivors(List<Survivor> records);

    List<Survivor> getSurvivors(Boolean infected);

    void updateLocation(UUID survivorId, double lat, double lon);

    void updateIsInfected(UUID survivorId, boolean isInfected);
}
