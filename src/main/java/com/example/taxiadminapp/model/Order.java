package com.example.taxiadminapp.model;

import lombok.Data;

@Data
public class Order {

    private Long id;

    private Driver driver;

    private Car car;

    private Client client;

    private Support support;

    private String address_from;

    private String address_to;

    private String client_mobile; // phone num
}
