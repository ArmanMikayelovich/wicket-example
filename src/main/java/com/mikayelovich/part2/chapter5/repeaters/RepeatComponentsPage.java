package com.mikayelovich.part2.chapter5.repeaters;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.repeater.RepeatingView;

public class RepeatComponentsPage extends WebPage {
    public RepeatComponentsPage() {
        RepeatingView repeat = new RepeatingView("repeat");
        add(repeat);

        for (int x = 0; x < 7; x++) {
            repeat.add(new Label("" + x, "Value" + x));
        }
    }
}
