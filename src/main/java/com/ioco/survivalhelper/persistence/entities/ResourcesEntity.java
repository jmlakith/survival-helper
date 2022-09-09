package com.ioco.survivalhelper.persistence.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Lakith Dharmarathna
 * Date : 09/09/2022
 */
@Entity
@Table(name = "resources")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ResourcesEntity {
    @Id
    @Column(name = "id")
    private int id;
    @Column(name = "item")
    private String item;
    @Column(name = "comment")
    private String comment;
}
