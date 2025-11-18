package com.example.tracetest.delegate;

import com.example.tracetest.model.Order;
import com.example.tracetest.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/orders")
public class GetOrdersDelegate {

    @Autowired
    private OrderRepository orderRepository;

    @GetMapping
    public List<Order> getOrderList(){
        return orderRepository.findAll();
    }

    @PostMapping
    public void createOrder(@RequestBody Order order){
        orderRepository.saveAndFlush(order);
    }
    @GetMapping("/{id}")
    public Order getOrderById(@PathVariable Long id){
        return orderRepository.findById(id).orElse(null);
    }
}
