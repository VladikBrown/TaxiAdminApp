package com.example.taxiadminapp.dto;

import com.example.taxiadminapp.model.Driver;
import lombok.Data;

import java.util.Set;

@Data
public class CarDto {

    private Long id;
    private String mark; //model KAKAYA NAHUI MARK
    private String number; //car_number
    private String klass; //....
    private String owner_type;

    private Set<Driver> drivers;
}
