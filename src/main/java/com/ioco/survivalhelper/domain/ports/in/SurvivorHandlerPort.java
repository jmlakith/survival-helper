package com.ioco.survivalhelper.domain.ports.in;

import com.ioco.survivalhelper.domain.dto.Survivor;

import java.util.List;

/**
 * @author Lakith Dharmarathna
 * Date : 09/09/2022
 */
public interface SurvivorHandlerPort {
    void addSurvivors(List<Survivor> survivors);

    List<Survivor> getSurvivors(boolean infected);
}
