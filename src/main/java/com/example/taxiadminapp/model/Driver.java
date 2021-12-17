package com.example.taxiadminapp.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.MappedCollection;
import org.springframework.data.relational.core.mapping.Table;

import java.util.Date;

@Data
@Table(value = "drivers")
public class Driver {

    @Id
    private Long id;
    private Long avto_id;
    private String firstname;
    private String secondname;
    private String therdname;
    private Integer age;
    private Date hire_date;
    private Date leave_date;
    private Double ocenka; //rename
    private String mobile; //phone_number
}
