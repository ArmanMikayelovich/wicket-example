package com.mikayelovich.part2.chapter4.tests;

import com.mikayelovich.part1.cheesr.model.Address;
import com.mikayelovich.part2.chapter4.form.Customer;
import com.mikayelovich.part2.chapter4.tests.model.LoadableCheeseModel;
import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.model.CompoundPropertyModel;
import org.apache.wicket.model.PropertyModel;

public class NestedExamplePage extends WebPage {
    public NestedExamplePage() {
        Customer customer = new Customer();
        customer.setName("John");
        customer.setAddress(new Address());
        customer.getAddress().setStreet("Xudyakov 7/4/13");
        add(new Label("name"));
        CompoundPropertyModel model = new CompoundPropertyModel(customer);
        setModel(model);
        add(new Label("street", model.bind("address.street")));


        add(new Form("cheeseform", new LoadableCheeseModel(1)));
        //TODO add  form get cheese  by id and print in page

        int cheeseId = 1;
        LoadableCheeseModel loadableCheeseModel = new LoadableCheeseModel(cheeseId);
        PropertyModel nameModel = new PropertyModel(loadableCheeseModel, "name");
        String name = (String) nameModel.getObject();
        nameModel.detach();

    }
}
