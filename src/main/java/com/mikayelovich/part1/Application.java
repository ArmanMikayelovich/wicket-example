package com.mikayelovich.part1;

import com.mikayelovich.part1.cheesr.CheesrApplication;
import com.mikayelovich.part1.input.InputsPage;
import org.apache.wicket.*;
import org.apache.wicket.protocol.http.WebApplication;

/**
 * Application object for your web application. If you want to run this application without deploying, run the Start class.
 * <p>
 * // * @see com.mikayelovich.Start#main(String[])
 */
public class Application extends WebApplication {


    /**
     * @see org.apache.wicket.Application#getHomePage()
     */
    public Class<? extends Page> getHomePage() {
        return InputsPage.class;
    }

    public static Application get() {
        return (Application) Application.get();
    }
}
