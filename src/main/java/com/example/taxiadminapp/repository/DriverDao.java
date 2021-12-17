package com.example.taxiadminapp.repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import com.example.taxiadminapp.model.*;
import com.example.taxiadminapp.model.Driver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class DriverDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private CommonJdbcDaoUtils commonJdbcDaoUtils;

    public static final String SELECT_ALL_DRIVER = "SELECT * FROM taxi.drivers\n" +
            "    JOIN avto a on a.id = drivers.avto_id\n" +
            "    JOIN avto_klass ak on a.klass = ak.id\n" +
            "    JOIN avto_owner_type aot on a.owner_type = aot.id";

    public List<Driver> findAllDrivers() {
        return null;
    }
}
