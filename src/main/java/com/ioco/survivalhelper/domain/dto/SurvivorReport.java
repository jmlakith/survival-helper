package com.ioco.survivalhelper.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author Lakith Dharmarathna
 * Date : 10/09/2022
 */
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class SurvivorReport {
    private double infectedPercentage;
    private double nonInfectedPercentage;
    private List<Survivor> infectedSurvivors;
    private List<Survivor> nonInfectedSurvivors;
}
