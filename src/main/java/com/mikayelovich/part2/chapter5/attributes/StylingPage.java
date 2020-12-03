package com.mikayelovich.part2.chapter5.attributes;

import org.apache.wicket.AttributeModifier;
import org.apache.wicket.behavior.SimpleAttributeModifier;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.model.Model;

public class StylingPage extends WebPage {
    public StylingPage() {
        add(new Label("text", "Hello, World")
                .add(new AttributeModifier("style", true,
                        new Model("color:red")))
        );

        Link link = new Link("link") {

            @Override
            public void onClick() {
                System.out.println("Link clicked");

            }
        };
        link.add(new SimpleAttributeModifier("onclick",
                "return confirm('Are you sure?')"));
        add(link);
    }
}
