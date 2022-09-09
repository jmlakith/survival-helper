package com.ioco.survivalhelper.persistence.repositories;

import com.ioco.survivalhelper.persistence.entities.SurvivorEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

/**
 * @author Lakith Dharmarathna
 * Date : 09/09/2022
 */
public interface SurvivorRepository extends JpaRepository<SurvivorEntity, UUID> {
    List<SurvivorEntity> findByIsInfected(boolean infected);
}