package com.example.taxiadminapp.repository;

import com.example.taxiadminapp.model.Car;
import com.example.taxiadminapp.model.Order;
import org.springframework.data.repository.CrudRepository;

public interface OrderRepository extends CrudRepository<Order, String> {
}
