package com.ioco.survivalhelper.application.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Lakith Dharmarathna
 * Date : 09/09/2022
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SurvivorInventoryRequest {
    private String item;
    private String comment;
}