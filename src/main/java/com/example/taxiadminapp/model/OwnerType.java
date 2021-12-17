package com.example.taxiadminapp.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Data
@Table("avto_owner_type")
public class OwnerType {

    @Id
    private Long id;
    private String owner_type;
}
