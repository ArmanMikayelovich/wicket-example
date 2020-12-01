package com.mikayelovich.part2.chapter4.clock;

import com.mikayelovich.part2.chapter4.form.MyForm;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.model.Model;

import java.time.LocalDateTime;

public class ClockPage extends WebPage {
    public ClockPage() {


        Model clockModel = new Model() {
            @Override
            public Object getObject() {
                return LocalDateTime.now();
            }
        };
        add(new Label("clock", clockModel));
        add(new Link("refresh") {
            @Override
            public void onClick() {

            }
        });

        add(new MyForm("form"));

    }
}
