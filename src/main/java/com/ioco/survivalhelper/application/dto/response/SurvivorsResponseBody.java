package com.ioco.survivalhelper.application.dto.response;

import com.ioco.survivalhelper.application.dto.request.SurvivorInventoryRequest;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

/**
 * @author Lakith Dharmarathna
 * Date : 09/09/2022
 */

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class SurvivorsResponseBody {

    private UUID id;
    private String name;
    private int age;
    private double lat;
    private double lon;
    private boolean isInfected = false;
    private List<SurvivorInventoryResponse> inventory;

}