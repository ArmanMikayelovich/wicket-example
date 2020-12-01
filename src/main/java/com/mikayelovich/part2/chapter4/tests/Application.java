package com.mikayelovich.part2.chapter4.tests;

import org.apache.wicket.protocol.http.WebApplication;

public class Application extends WebApplication {
    @Override
    public Class getHomePage() {
        return NestedExamplePage.class;
    }
}
