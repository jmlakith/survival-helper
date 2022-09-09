package com.ioco.survivalhelper.domain.services;

import com.ioco.survivalhelper.domain.dto.Survivor;
import com.ioco.survivalhelper.domain.ports.in.SurvivorHandlerPort;
import com.ioco.survivalhelper.domain.ports.out.SurvivorPersistencePort;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

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
    public List<Survivor> getSurvivors(boolean infected) {
        return survivorPersistencePort.getSurvivors(infected);
    }

}
