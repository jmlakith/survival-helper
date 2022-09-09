package com.ioco.survivalhelper.application.dto;

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
public class CheckInfectedRequestBody {
    private boolean isInfected;
}
