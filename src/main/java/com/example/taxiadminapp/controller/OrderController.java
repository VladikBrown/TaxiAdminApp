package com.example.taxiadminapp.controller;

import com.example.taxiadminapp.dto.OrderDto;
import com.example.taxiadminapp.model.Client;
import com.example.taxiadminapp.model.Driver;
import com.example.taxiadminapp.model.Order;
import com.example.taxiadminapp.repository.ClientRepository;
import com.example.taxiadminapp.repository.DriverRepository;
import com.example.taxiadminapp.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping( "/orders")
public class OrderController {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private ClientRepository clientRepository;
    @Autowired
    private DriverRepository driverRepository;

    @GetMapping("/")
    public ResponseEntity<Iterable<Order>> getAllOrders() {
        var orders = orderRepository.findAll();
        return new ResponseEntity<Iterable<Order>>(orders, HttpStatus.OK);
    }

    @GetMapping("/{id}")
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
    public ResponseEntity<Order> createDriver(@RequestBody OrderDto orderDto) {
        if (orderDto != null) {
            Client client = new Client();
            client.setName(orderDto.getName());
            client.setPhoneNumber(orderDto.getMobile());
            var savedClient = clientRepository.save(client);
            Order order = new Order();
            order.setClient_id(savedClient.getId());
            order.setDriver_id(Long.valueOf(orderDto.getDriver_id()));
            Driver driver = driverRepository.findById(orderDto.getDriver_id()).get();
            order.setAvto_id(driver.getAvto_id());
            order.setAddress_from(orderDto.getAddress_from());
            order.setAddress_to(orderDto.getAddress_to());
            var savedOrder = orderRepository.save(order);
            return new ResponseEntity<Order>(savedOrder, HttpStatus.CREATED);
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
