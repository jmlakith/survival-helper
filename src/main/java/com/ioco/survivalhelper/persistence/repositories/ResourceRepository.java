package com.ioco.survivalhelper.persistence.repositories;

import com.ioco.survivalhelper.persistence.entities.ResourcesEntity;
import com.ioco.survivalhelper.persistence.entities.SurvivorEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

/**
 * @author Lakith Dharmarathna
 * Date : 09/09/2022
 */
public interface ResourceRepository extends JpaRepository<ResourcesEntity, Long> {
}