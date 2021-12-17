package com.example.taxiadminapp.dto;

import lombok.Data;

@Data
public class OrderDto {

    private String name;
    private String mobile;
    private String address_from;
    private String address_to;
    private String driver_id;
    private String avto_id;
    private String client_id;
    private String sotrudnik_id;

}
