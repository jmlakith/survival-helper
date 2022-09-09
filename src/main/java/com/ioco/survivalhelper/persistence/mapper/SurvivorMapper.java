package com.ioco.survivalhelper.persistence.mapper;

import com.ioco.survivalhelper.domain.dto.Survivor;
import com.ioco.survivalhelper.domain.dto.SurvivorResources;
import com.ioco.survivalhelper.persistence.entities.ResourcesEntity;
import com.ioco.survivalhelper.persistence.entities.SurvivorEntity;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

/**
 * @author Lakith Dharmarathna
 * Date : 09/09/2022
 */
public class SurvivorMapper {

    private SurvivorMapper() {
    }

    public static List<SurvivorEntity> dtoToEntityTransformation(List<Survivor> survivors) {

        return survivors.stream().map(survivor -> {

            SurvivorEntity entity = SurvivorEntity.builder().id(survivor.getId().toString())
                .name(survivor.getName())
                .age(survivor.getAge())
                .isInfected(survivor.isInfected())
                .lat(survivor.getLat())
                .lon(survivor.getLon()).build();
            List<ResourcesEntity> resources = survivor.getInventory().stream().map(resource -> ResourcesEntity.builder()
                        .item(resource.getItem())
                        .comment(resource.getComment())
                        .survivor(entity).build()).collect(Collectors.toList());
            entity.setResources(resources);
            return entity;
        }).collect(Collectors.toList());
    }

    public static List<Survivor> entityToDtoTransformation(List<SurvivorEntity> records) {
        return records.stream().map(survivorEntity -> Survivor.builder()
                .id(UUID.fromString(survivorEntity.getId()))
                .name(survivorEntity.getName())
                .age(survivorEntity.getAge())
                .isInfected(survivorEntity.isInfected())
                .lat(survivorEntity.getLat())
                .lon(survivorEntity.getLon())
                .inventory(survivorEntity.getResources().stream().map(resource -> SurvivorResources.builder()
                        .item(resource.getItem())
                        .comment(resource.getComment()).build()).collect(Collectors.toList())).build()).collect(Collectors.toList());
    }
}
