package com.ioco.survivalhelper.persistence.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.lang.Nullable;

import javax.persistence.*;

/**
 * @author Lakith Dharmarathna
 * Date : 09/09/2022
 */
@Entity
@Table(name = "resource")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ResourcesEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;
    @Column(name = "item")
    private String item;
    @Column(name = "comment")
    private String comment;
    @ManyToOne
    @JoinColumn(name = "survivor_id")
    private SurvivorEntity survivor;
}
