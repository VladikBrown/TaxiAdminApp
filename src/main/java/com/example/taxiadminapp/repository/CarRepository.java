package com.example.taxiadminapp.repository;

import com.example.taxiadminapp.model.Car;
import com.example.taxiadminapp.model.Driver;
import org.springframework.data.repository.CrudRepository;

public interface CarRepository  extends CrudRepository<Car, String> {
}
