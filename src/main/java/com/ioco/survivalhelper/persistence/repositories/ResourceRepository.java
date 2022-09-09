package com.ioco.survivalhelper.persistence.repositories;

import com.ioco.survivalhelper.persistence.entities.ResourcesEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Lakith Dharmarathna
 * Date : 09/09/2022
 */
public interface ResourceRepository extends JpaRepository<ResourcesEntity, Long> {
}