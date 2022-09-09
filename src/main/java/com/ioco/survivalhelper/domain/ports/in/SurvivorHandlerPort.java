package com.ioco.survivalhelper.domain.ports.in;

import com.ioco.survivalhelper.domain.dto.Survivor;
import com.ioco.survivalhelper.domain.dto.response.SurvivorReport;

import java.util.List;
import java.util.UUID;

/**
 * @author Lakith Dharmarathna
 * Date : 09/09/2022
 */
public interface SurvivorHandlerPort {
    void addSurvivors(List<Survivor> survivors);

    List<Survivor> getSurvivors(Boolean infected);

    void updateLocation(UUID survivorId, double lat, double lon);

    void updateIsInfected(UUID survivorId, boolean isInfected);

    SurvivorReport getSurvivorReport();
}
