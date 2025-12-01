package com.example.tracetest.model;

public class Invoice {
    private int id;
    private int items;
    private double totalAmount;

    public Invoice() {
    }

    public Invoice(int id, int items, double totalAmount) {
        this.id = id;
        this.items = items;
        this.totalAmount = totalAmount;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getItems() {
        return items;
    }

    public void setItems(int items) {
        this.items = items;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }
}
