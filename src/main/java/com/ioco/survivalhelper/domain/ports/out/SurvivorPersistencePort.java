package com.ioco.survivalhelper.domain.ports.out;

import com.ioco.survivalhelper.domain.dto.SurvivorRecords;

import java.util.List;

/**
 * @author Lakith Dharmarathna
 * Date : 09/09/2022
 */
public interface SurvivorPersistencePort {
    void saveSurvivors(List<SurvivorRecords> records);
}
