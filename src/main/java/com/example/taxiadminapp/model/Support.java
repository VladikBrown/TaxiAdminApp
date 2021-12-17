package com.example.taxiadminapp.model;

import lombok.Data;

import java.util.Date;

@Data
public class Support {

    private Long id;

    private String name;

    private String phoneNumber;

    private Date hire_date;

    private Date leave_date;
}
