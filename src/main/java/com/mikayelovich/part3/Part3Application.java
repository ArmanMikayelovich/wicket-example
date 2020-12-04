package com.mikayelovich.part3;

import com.mikayelovich.part2.chapter5.TestPage;

import org.apache.wicket.Page;
import org.apache.wicket.protocol.http.WebApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Part3Application extends WebApplication {
    private ApplicationContext context;

    @Override
    protected void init() {
        context = new ClassPathXmlApplicationContext("sprintConfiguration.xml");
    }

    @Override
    public Class<? extends Page> getHomePage() {
        return TestPage.class;
    }

}
