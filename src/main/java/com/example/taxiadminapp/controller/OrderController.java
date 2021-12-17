package com.example.taxiadminapp.controller;

import com.example.taxiadminapp.model.Driver;
import com.example.taxiadminapp.model.Order;
import com.example.taxiadminapp.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController("/orders")
public class OrderController {

    @Autowired
    private OrderRepository orderRepository;

    @GetMapping
    public ResponseEntity<Iterable<Order>> getAllOrders() {
        var orders = orderRepository.findAll();
        return new ResponseEntity<Iterable<Order>>(orders, HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<Order> getOrder(@PathVariable String id) {
        var order = orderRepository.findById(id);
        return order.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteDriver(@PathVariable String id) {
        orderRepository.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<Order> createDriver(@RequestBody Order order) {
        if (order != null) {
            var orderResponse= orderRepository.save(order);
            return new ResponseEntity<Order>(orderResponse, HttpStatus.CREATED);
        } else {
            return new ResponseEntity<Order>(HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Order> updateDriver(@PathVariable String id, @RequestBody Order order) {
        if (order != null) {
            var driverResponse= orderRepository.save(order);
            return new ResponseEntity<Order>(order, HttpStatus.OK);
        } else {
            return new ResponseEntity<Order>(HttpStatus.BAD_REQUEST);
        }
    }
}
