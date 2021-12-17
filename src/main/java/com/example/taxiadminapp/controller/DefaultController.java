package com.example.taxiadminapp.controller;

import com.example.taxiadminapp.model.CarClass;
import com.example.taxiadminapp.model.Client;
import com.example.taxiadminapp.model.OwnerType;
import com.example.taxiadminapp.model.Support;
import com.example.taxiadminapp.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DefaultController {

    @Autowired
    private ClienRepository clienRepository;
    @Autowired
    private CarClassRepository carClassRepository;
    @Autowired
    private OwnerTypeRepository ownerTypeRepository;
    @Autowired
    private SupportRepository supportRepository;
    @Autowired
    private CarRepository carRepository;

    @GetMapping("/clients")
    public ResponseEntity<Iterable<Client>> getClients() {
        return new ResponseEntity<>(clienRepository.findAll(), HttpStatus.OK);
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
}
