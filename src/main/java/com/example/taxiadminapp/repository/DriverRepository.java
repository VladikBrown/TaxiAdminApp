package com.example.taxiadminapp.repository;

import com.example.taxiadminapp.model.Driver;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DriverRepository extends CrudRepository<Driver, String> {

    @Override
    Iterable<Driver> findAll();
}
