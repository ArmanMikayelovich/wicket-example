package com.mikayelovich.part3.chapter9;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Discount {
    private String cheeseName;
    private Double percent;
}

