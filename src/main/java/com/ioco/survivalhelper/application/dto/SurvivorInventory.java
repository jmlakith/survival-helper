package com.ioco.survivalhelper.application.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Lakith Dharmarathna
 * Date : 09/09/2022
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SurvivorInventory {
    private String item;
    private String comment;
}