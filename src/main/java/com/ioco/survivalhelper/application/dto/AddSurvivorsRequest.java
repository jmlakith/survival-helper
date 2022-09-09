package com.ioco.survivalhelper.application.dto;

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
class Inventory {
    public String item;
    public String comment;
}

@AllArgsConstructor
@NoArgsConstructor
@Data
public class AddSurvivorsRequest {

    @NonNull
    public String id;

    @NonNull
    public String name;

    @NonNull
    public int age;

    @NonNull
    public double lat;

    @NonNull
    public double lon;

    public boolean isInfected = false;
    public List<Inventory> inventory;
}
