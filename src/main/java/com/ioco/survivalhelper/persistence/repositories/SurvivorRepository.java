package com.ioco.survivalhelper.persistence.repositories;

import com.ioco.survivalhelper.persistence.entities.SurvivorEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author Lakith Dharmarathna
 * Date : 09/09/2022
 */
public interface SurvivorRepository extends JpaRepository<SurvivorEntity, String> {
    List<SurvivorEntity> findByIsInfected(boolean infected);
}