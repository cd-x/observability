package com.example.tracetest.delegate;

import com.example.tracetest.model.Order;
import com.example.tracetest.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/orders")
public class OrdersController {

    @Autowired
    private OrderRepository orderRepository;

    @GetMapping
    public List<Order> getOrderList(){
        return orderRepository.findAll();
    }

    @PostMapping
    public void createOrder(@RequestBody Order order){
        order.setId(UUID.randomUUID().toString());
        order.setBoughtAt(new Date());
        orderRepository.save(order);
    }
    @GetMapping("/{id}")
    public Order getOrderById(@PathVariable String id){
        return orderRepository.findById(id).orElse(null);
    }
}
