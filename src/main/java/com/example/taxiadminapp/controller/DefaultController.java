package com.example.taxiadminapp.controller;

import com.example.taxiadminapp.dto.DriverDto;
import com.example.taxiadminapp.model.*;
import com.example.taxiadminapp.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.LinkedList;
import java.util.List;

@RestController
public class DefaultController {

    @Autowired
    private ClientRepository clientRepository;
    @Autowired
    private CarClassRepository carClassRepository;
    @Autowired
    private OwnerTypeRepository ownerTypeRepository;
    @Autowired
    private SupportRepository supportRepository;
    @Autowired
    private CarRepository carRepository;
    @Autowired
    private DriverRepository driverRepository;


    @GetMapping("/clients")
    public ResponseEntity<Iterable<Client>> getClients() {
        return new ResponseEntity<>(clientRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping("/avto_klass")
    public ResponseEntity<Iterable<CarClass>> getCarClasses() {
        return new ResponseEntity<>(carClassRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping("/avto_owner_types")
    public ResponseEntity<Iterable<OwnerType>> getOwnerTypes() {
        return new ResponseEntity<>(ownerTypeRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping("/supports")
    public ResponseEntity<Iterable<Support>> getSupports() {
        return new ResponseEntity<>(supportRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping("/cars")
    public ResponseEntity<Iterable<Support>> getCars() {
        return new ResponseEntity<>(supportRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping("/selectdriver")
    public ResponseEntity<List<DriverDto>> selectDriver() {
        List<DriverDto> driverDtos = new LinkedList<>();
        Iterable<Driver> drivers = driverRepository.findAll();
        for (var driver : drivers) {
            driverDtos.add(convertToDto(driver));
        }
        return new ResponseEntity<>(driverDtos, HttpStatus.OK);
    }

    private DriverDto convertToDto(Driver driver) {
        DriverDto driverDto = new DriverDto();
        driverDto.setAge(driver.getAge());
        driverDto.setFirstname(driver.getFirstname());
        driverDto.setHire_date(driver.getHire_date());
        driverDto.setId(String.valueOf(driver.getId()));
        driverDto.setKlass(driver.getAvto().getAvto_klass().getKlass());
        driverDto.setLeave_date(driver.getLeave_date());
        driverDto.setMark(driver.getAvto().getMark());
        driverDto.setMobile(driver.getMobile());
        driverDto.setNumber(driver.getAvto().getNumber());
        driverDto.setOcenka(driver.getOcenka());
        return driverDto;
    }
}
