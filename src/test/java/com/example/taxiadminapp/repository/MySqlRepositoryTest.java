package com.example.taxiadminapp.repository;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@DataJpaTest
class MySqlRepositoryTest {

    @Autowired
    DriverRepository driverRepository;

    @Test
    void testFindAllDrivers() {
        var drivers = driverRepository.findAll();
        System.out.println(drivers.toString());
    }
}