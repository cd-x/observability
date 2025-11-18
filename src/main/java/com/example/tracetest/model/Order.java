package com.example.tracetest.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;


@Data
@AllArgsConstructor
@Entity
@Table(name = "orders")
@NoArgsConstructor
public class Order {
    @Id
    private String id;
    private Date boughtAt;
    private String name;
    private double amount;
    private int quantity;
}
