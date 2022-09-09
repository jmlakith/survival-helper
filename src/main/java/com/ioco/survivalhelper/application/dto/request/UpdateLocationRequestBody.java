package com.ioco.survivalhelper.application.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.lang.NonNull;

/**
 * @author Lakith Dharmarathna
 * Date : 09/09/2022
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class UpdateLocationRequestBody {
    @NonNull
    private double lat;
    @NonNull
    private double lon;
}
