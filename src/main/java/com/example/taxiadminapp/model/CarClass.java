package com.example.taxiadminapp.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Data
@Table("avto_klass")
public class CarClass {

    @Id
    private Long id;
    private String klass;
}
