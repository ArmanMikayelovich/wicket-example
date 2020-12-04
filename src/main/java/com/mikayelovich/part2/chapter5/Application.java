package com.mikayelovich.part2.chapter5;

import org.apache.wicket.Page;
import org.apache.wicket.protocol.http.WebApplication;

public class Application extends WebApplication {

    @Override
    public Class<? extends Page> getHomePage() {
        return TestPage.class;
    }

    public static Application getInstance() {
        return (Application) org.apache.wicket.Application.get();
    }


}
