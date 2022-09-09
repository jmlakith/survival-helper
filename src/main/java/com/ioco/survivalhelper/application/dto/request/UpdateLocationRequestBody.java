package com.ioco.survivalhelper.application.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Lakith Dharmarathna
 * Date : 09/09/2022
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class UpdateLocationRequestBody {
    private double lat;
    private double lon;
}
