package com.mikayelovich.part1.cheesr.model;

import lombok.Data;

import java.io.Serializable;

@Data
public class Address implements Serializable {

    private String name;
    private String street;
    private Integer zipcode;
    private String city;

}


