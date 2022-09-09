package com.ioco.survivalhelper.persistence.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.lang.NonNull;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;

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
    @OneToMany(mappedBy = "survivor", cascade = CascadeType.ALL)
    private List<ResourcesEntity> resources;
}
