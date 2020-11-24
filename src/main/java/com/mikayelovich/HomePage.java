package com.mikayelovich;

import org.apache.wicket.Component;
import org.apache.wicket.PageParameters;
import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.markup.html.AjaxFallbackLink;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.model.PropertyModel;

/**
 * Homepage
 */
public class HomePage extends WebPage {

    private static final long serialVersionUID = 1L;
    private int counter;
    private Label ajaxLabel;
    // TODO Add any page properties or variables here

    /**
     * Constructor that is invoked when page is invoked without a session.
     *
     * @param parameters Page parameters
     */
    public HomePage(final PageParameters parameters) {

        // Add the simplest type of label
        add(new Label("message", "Heeki,CHunia"));
        add(new Label("lbl2", "My Custom <h3> label"));


        addLinkWithCounter();
        // TODO Add your page's components here
    }


    private void addLinkWithCounter() {
        final Link link = new Link("link") {
            @Override
            public void onClick() {
                counter++;
            }
        };

        final Label label = new Label("count", new PropertyModel(this, "counter"));

        add(link);
        add(label);

        add(new AjaxFallbackLink("ajaxLink") {
            @Override
            public void onClick(AjaxRequestTarget target) {
                counter++;
                if (target != null) {
                    target.addComponent(ajaxLabel);

                }
            }
        });
        ajaxLabel = new Label("ajaxCount", new PropertyModel(this, "counter"));
        ajaxLabel.setOutputMarkupId(true);
        add(ajaxLabel);

    }

}
