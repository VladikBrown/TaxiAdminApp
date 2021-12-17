package com.example.taxiadminapp.dto;

import lombok.Data;

import java.util.Date;

@Data
public class DriverDto {

    String id;
    String firstname;
    String secondname;
    String therdname;
    Integer age;
    Date hire_date;
    Date leave_date;
    Double ocenka;
    String mobile;
    String mark;
    String number;
    String klass;
}
