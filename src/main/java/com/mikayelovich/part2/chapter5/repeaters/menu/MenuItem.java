package com.mikayelovich.part2.chapter5.repeaters.menu;

import lombok.Getter;
import lombok.Setter;
import org.apache.wicket.markup.html.WebPage;

import java.io.Serializable;
@Getter
@Setter
public class MenuItem implements Serializable {
    public MenuItem(String caption, Class<? extends WebPage> destination) {
        this.caption = caption;
        this.destination = destination;
    }

    private String caption;

    private Class<? extends WebPage> destination;

}
