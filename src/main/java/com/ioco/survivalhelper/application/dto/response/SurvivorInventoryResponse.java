package com.ioco.survivalhelper.application.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Lakith Dharmarathna
 * Date : 09/09/2022
 */

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SurvivorInventoryResponse {
    private String item;
    private String comment;
}
