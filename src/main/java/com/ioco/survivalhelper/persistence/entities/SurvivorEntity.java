package com.ioco.survivalhelper.persistence.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.lang.NonNull;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Lakith Dharmarathna
 * Date : 09/09/2022
 */
@Entity
@Table(name = "survivor")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SurvivorEntity {
    @Id
    @Column(name = "id")
    private String id;
    @Column(name = "name")
    private String name;
    @Column(name = "age")
    private int age;
    @Column(name = "lat")
    private double lat;
    @Column(name = "lon")
    private double lon;
    @Column(name = "is_infected")
    private boolean isInfected;
}
