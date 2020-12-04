package com.mikayelovich.part3.chapter9;

import com.mikayelovich.part3.Part3Application;
import org.apache.wicket.Application;
import org.apache.wicket.IInitializer;
import org.apache.wicket.SharedResources;
import org.apache.wicket.markup.html.WebResource;
import org.apache.wicket.util.resource.IResourceStream;
import org.apache.wicket.util.resource.StringResourceStream;

public class DiscountExport extends WebResource {
    @Override
    public IResourceStream getResourceStream() {
        CharSequence charSequence = TestPage.getDiscounts();
        return new StringResourceStream(charSequence,"text/csv");
    }

    public static class Initializer implements IInitializer {

        @Override
        public void init(Application application) {
            SharedResources sharedResources = Part3Application.get().getSharedResources();
            sharedResources.add("discounts", new DiscountExport());
        }
    }
}
