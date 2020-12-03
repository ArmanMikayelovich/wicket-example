package com.mikayelovich.part2.chapter6;

import com.mikayelovich.part1.cheesr.model.Cheese;
import lombok.Data;
import lombok.Getter;

@Data
public class CheeseWithMilkType extends Cheese {


    public CheeseWithMilkType(String name, String description, Double price) {
        super(name, description, price);
    }

    public CheeseWithMilkType() {
        super("no name", "no description", 0.0);
    }

    private MilkType milkType;
}
