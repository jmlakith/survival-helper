package com.ioco.survivalhelper.domain.dto;

import com.ioco.survivalhelper.domain.enums.RobotType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Lakith Dharmarathna
 * Date : 10/09/2022
 */
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class Robot {

    private String model;
    private String serialNumber;
    private String manufacturedDate;
    private RobotType category;
}
