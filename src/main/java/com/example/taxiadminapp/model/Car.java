package com.example.taxiadminapp.model;

import lombok.Data;
import org.springframework.data.relational.core.mapping.MappedCollection;
import org.springframework.data.relational.core.mapping.Table;

import java.util.Set;

@Data
@Table("avto")
public class Car {

    private Long id;
    private String mark; //model KAKAYA NAHUI MARK
    private String number; //car_number
    private String klass; //....
    private String owner_type;

    @MappedCollection(idColumn = "klass")
    private CarClass avto_klass;
}
