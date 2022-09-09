package com.ioco.survivalhelper.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author Lakith Dharmarathna
 * Date : 09/09/2022
 */
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class SurvivorRecords {
    private String id;
    private String name;
    private int age;
    private double lat;
    private double lon;
    private boolean isInfected = false;
    private List<SurvivorResourceRecords> inventory;
}

