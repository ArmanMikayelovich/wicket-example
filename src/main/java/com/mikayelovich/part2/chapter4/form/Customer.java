package com.mikayelovich.part2.chapter4.form;

import com.mikayelovich.part1.cheesr.model.Address;
import lombok.Data;

import java.io.Serializable;

@Data
public class Customer implements Serializable {
    private String name;
    private Address address;

    public String getName() {
        System.out.println("getName()");
        return name;
    }

    public void setName(String name) {
        System.out.println("setName(old: " + this.name + ", new: " + name + ")");
        this.name = name;
    }

    public Address getAddress() {
        System.out.println("getAddress()");
        return address;
    }

    public void setAddress(Address address) {
        System.out.println("setAddress(old: " + this.address + ", new: " + address + ")");
        this.address = address;
    }
}
