package com.example.taxiadminapp.controller;

import com.example.taxiadminapp.model.Car;
import com.example.taxiadminapp.model.Driver;
import com.example.taxiadminapp.repository.CarRepository;
import com.example.taxiadminapp.repository.DriverRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController("/drivers")
public class DriverController {

    @Autowired
    private DriverRepository driverRepository;

    @Autowired
    private CarRepository carRepository;

    @GetMapping("/")
    public ResponseEntity<Iterable<Driver>> getDrivers() {
        var drivers = driverRepository.findAll();
        return new ResponseEntity<Iterable<Driver>>(drivers, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Driver> getDriver(@PathVariable String id) {
        var driver = driverRepository.findById(id);
        return driver.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteDriver(@PathVariable String id) {
        driverRepository.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<Driver> createDriver(@RequestBody Driver driver) {
        if (driver != null) {
            var driverResponse= driverRepository.save(driver);
            return new ResponseEntity<Driver>(driver, HttpStatus.CREATED);
        } else {
            return new ResponseEntity<Driver>(HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Driver> updateDriver(@PathVariable String id, @RequestBody Driver driver) {
        if (driver != null) {
            var driverResponse= driverRepository.save(driver);
            return new ResponseEntity<Driver>(driver, HttpStatus.OK);
        } else {
            return new ResponseEntity<Driver>(HttpStatus.BAD_REQUEST);
        }
    }
}
