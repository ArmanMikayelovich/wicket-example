package com.mikayelovich.part2.chapter5;

import org.apache.wicket.PageParameters;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.ListView;
import org.apache.wicket.model.Model;
import org.apache.wicket.model.PropertyModel;

import java.util.*;

public class ParameterizedPage extends WebPage {
    public ParameterizedPage(PageParameters parameters) {
        super(parameters);
        Set parameterKeySet = parameters.keySet();
        add(new ListView("param", Arrays.asList(parameterKeySet.toArray())) {
            @Override
            protected void populateItem(ListItem item) {
                String key = (String)item.getModelObject();
                item.add(new Label("param.name", key));
                item.add(new Label("param.value", parameters.getStringValue(key).toString()));

            }
        });
    }



}
