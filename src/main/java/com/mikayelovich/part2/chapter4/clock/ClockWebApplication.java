package com.mikayelovich.part2.chapter4.clock;

import org.apache.wicket.protocol.http.WebApplication;

public class ClockWebApplication extends WebApplication {

    @Override
    public Class getHomePage() {
        return ClockPage.class;
    }
}
