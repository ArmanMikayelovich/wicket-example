package com.mikayelovich.cheesr.model;

import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
public class Cart implements Serializable {

    private List<Cheese> cheeses = new ArrayList<>();

    private Address billingAddress = new Address();


    public Double getTotal() {
        double total = 0;
        for (Cheese cheese : cheeses) {
            total += cheese.getPrice();
        }
        return total;
    }


}
