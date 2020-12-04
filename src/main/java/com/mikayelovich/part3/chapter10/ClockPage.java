package com.mikayelovich.part3.chapter10;

import org.apache.wicket.ajax.AjaxSelfUpdatingTimerBehavior;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.util.time.Duration;

import java.util.TimeZone;
public class ClockPage extends WebPage {
    public ClockPage() {
        TimeZone tz = TimeZone.getTimeZone("America/Los_Angeles");
        Clock clock = new Clock("clock", tz);
        add(clock);
        clock.add(new AjaxSelfUpdatingTimerBehavior(Duration.milliseconds(500)));
    }
}
