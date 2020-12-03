package com.mikayelovich.part2.chapter6;

import org.apache.wicket.markup.html.WebPage;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ChoisePage extends WebPage {
    List<MilkType> list = Arrays.asList(new MilkType("1", "Cow"), new MilkType("2", "Sheep"),
    new MilkType("3","Goat"));

    public ChoisePage() {
    }
}
