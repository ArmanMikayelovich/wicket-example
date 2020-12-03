package com.mikayelovich.part1.cheesr.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

@Data
@AllArgsConstructor

public class Cheese implements Serializable {
    private String name;

    private String description;
    private Double price;

    public Cheese() {
        this.name = name;
    }
}
