package com.ioco.survivalhelper.application.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.lang.NonNull;

import java.util.List;
import java.util.UUID;

/**
 * @author Lakith Dharmarathna
 * Date : 09/09/2022
 */

@AllArgsConstructor
@NoArgsConstructor
@Data
public class NewSurvivorsRequest {

    @NonNull
    private UUID id;
    @NonNull
    private String name;
    @NonNull
    private int age;
    @NonNull
    private double lat;
    @NonNull
    private double lon;
    private boolean isInfected = false;
    private List<SurvivorInventoryRequest> inventory;

}