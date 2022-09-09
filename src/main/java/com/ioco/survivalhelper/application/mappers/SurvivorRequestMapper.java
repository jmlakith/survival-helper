package com.ioco.survivalhelper.application.mappers;

import com.ioco.survivalhelper.application.dto.request.AddSurvivorsRequestBody;
import com.ioco.survivalhelper.application.dto.response.SurvivorInventoryResponse;
import com.ioco.survivalhelper.application.dto.response.SurvivorsResponseBody;
import com.ioco.survivalhelper.domain.dto.Survivor;
import com.ioco.survivalhelper.domain.dto.SurvivorResources;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Lakith Dharmarathna
 * Date : 09/09/2022
 */
public class SurvivorRequestMapper {

    private SurvivorRequestMapper() {
    }

    public static List<Survivor> requestBodyToDtoTransform(AddSurvivorsRequestBody request) {

        return request.getSurvivors().stream().map(survivor -> Survivor.builder()
                .id(survivor.getId())
                .name(survivor.getName())
                .age(survivor.getAge())
                .isInfected(survivor.getIsInfected())
                .lat(survivor.getLat())
                .lon(survivor.getLon())
                .inventory(survivor.getInventory().stream().map(resource -> SurvivorResources.builder()
                        .item(resource.getItem())
                        .comment(resource.getComment())
                        .build()).collect(Collectors.toList()))
                .build()).collect(Collectors.toList());

    }

    public static List<SurvivorsResponseBody> dtoToResponseBodyTransform(List<Survivor> survivors) {

        return survivors.stream().map(survivor -> SurvivorsResponseBody.builder()
                .id(survivor.getId())
                .name(survivor.getName())
                .age(survivor.getAge())
                .isInfected(survivor.isInfected())
                .lat(survivor.getLat())
                .lon(survivor.getLon())
                .inventory(survivor.getInventory().stream().map(resource -> SurvivorInventoryResponse.builder()
                        .item(resource.getItem())
                        .comment(resource.getComment())
                        .build()).collect(Collectors.toList()))
                .build()).collect(Collectors.toList());
    }
}
