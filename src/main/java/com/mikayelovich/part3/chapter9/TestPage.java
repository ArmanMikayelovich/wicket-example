package com.mikayelovich.part3.chapter9;

import org.apache.wicket.ResourceReference;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.image.Image;
import org.apache.wicket.markup.html.link.Link;

public class TestPage extends WebPage {
    public TestPage() {
        Link link = new Link("clickMe") {
            @Override
            public void onClick() {
                System.out.println("Clicked!!");

            }
        };


        Link deleteLink = new Link("clickMe") {
            @Override
            public void onClick() {
                System.out.println("Clicked!!");

            }
        };
        link.add(new Image("clickIcon", new ResourceReference(TestPage.class, "click.png")));
        add(link);
    }
}
