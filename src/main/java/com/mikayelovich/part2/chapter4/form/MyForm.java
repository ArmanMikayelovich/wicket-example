package com.mikayelovich.part2.chapter4.form;

import com.mikayelovich.part1.cheesr.model.Address;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.Button;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.model.CompoundPropertyModel;
import org.apache.wicket.model.Model;
import org.apache.wicket.model.PropertyModel;

public class MyForm extends Form {
    public MyForm(String id) {
        super(id);
        Customer customer = new Customer();
        setModel(new CompoundPropertyModel(customer));
        add(new TextField("name"));
        add(new TextField("address.street"));
        add(new Button("submit"));
    }


    @Override
    protected void onSubmit() {
    }
}
