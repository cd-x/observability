package com.example.tracetest.delegate;

import com.example.tracetest.model.Order;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/orders")
public class GetOrdersDelegate {

    @GetMapping
    public List<Order> getOrderList(){
        return List.of(new Order(UUID.randomUUID().toString(), new Date()));
    }
}
