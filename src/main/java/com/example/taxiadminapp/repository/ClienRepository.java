package com.example.taxiadminapp.repository;

import com.example.taxiadminapp.model.Client;
import org.springframework.data.repository.CrudRepository;

public interface ClienRepository extends CrudRepository<Client, Long> {
}
