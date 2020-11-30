package com.mikayelovich;

import com.mikayelovich.cheesr.model.Cheese;
import com.mikayelovich.cheesr.session.CheesrSession;
import com.mikayelovich.input.InputsPage;
import org.apache.wicket.*;
import org.apache.wicket.protocol.http.WebApplication;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

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


}
