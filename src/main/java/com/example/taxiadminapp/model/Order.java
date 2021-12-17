package com.example.taxiadminapp.model;

import lombok.Data;
import org.springframework.data.relational.core.mapping.MappedCollection;

@Data
public class Order {

    private Long id;

    private Long avto_id;

    private Long client_id;

    private Long driver_id;

    @MappedCollection(idColumn = "id")
    private Driver driver;

    @MappedCollection(idColumn = "id")
    private Car avto;

    @MappedCollection(idColumn = "id")
    private Client clients;

    @MappedCollection(idColumn = "id")
    private Support support;

    private String address_from;

    private String address_to;

    private String client_mobile; // phone num

}
