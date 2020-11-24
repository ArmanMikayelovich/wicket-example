package com.mikayelovich;

import org.apache.wicket.IClusterable;
import org.apache.wicket.protocol.http.WebApplication;

/**
 * Application object for your web application. If you want to run this application without deploying, run the Start class.
 * <p>
 * // * @see com.mikayelovich.Start#main(String[])
 */
public class WicketApplication extends WebApplication {


    /**
     * @see org.apache.wicket.Application#getHomePage()
     */
    public Class<? extends IClusterable> getHomePage() {
        return HomePage.class;
    }

}
