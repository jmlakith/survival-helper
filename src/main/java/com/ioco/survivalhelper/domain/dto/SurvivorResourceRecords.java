package com.ioco.survivalhelper.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Lakith Dharmarathna
 * Date : 09/09/2022
 */
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class SurvivorResourceRecords {
    private String item;
    private String comment;
}

