package com.ioco.survivalhelper.domain.ports.out;

import com.ioco.survivalhelper.domain.dto.Survivor;

import java.util.List;

/**
 * @author Lakith Dharmarathna
 * Date : 09/09/2022
 */
public interface SurvivorPersistencePort {
    void saveSurvivors(List<Survivor> records);

    List<Survivor> getSurvivors(boolean infected);
}
