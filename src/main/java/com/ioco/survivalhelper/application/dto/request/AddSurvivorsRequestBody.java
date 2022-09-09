package com.ioco.survivalhelper.application.dto.request;

import lombok.*;
import org.springframework.lang.NonNull;

import java.util.List;

/**
 * @author Lakith Dharmarathna
 * Date : 09/09/2022
 */

@AllArgsConstructor
@NoArgsConstructor
@Data
public class AddSurvivorsRequestBody {
    @NonNull
    private List<NewSurvivorsRequest> survivors;

}

