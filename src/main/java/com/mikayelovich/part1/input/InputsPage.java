package com.mikayelovich.part1.input;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.Button;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.model.Model;

public class InputsPage extends WebPage {

    private Label label;

    private TextField field;

    public InputsPage() {
        Form form = new Form("form");
        field = new TextField("field", new Model());
        form.add(field);
        form.add(new Button("button") {
            @Override
            public void onSubmit() {
                String value = (String) field.getModelObject();
                System.out.println(field.getModelObject());
                label.setModelObject(value);
                field.setModelObject("");
            }
        });
        add(form);
        label = new Label("message", new Model(""));
        add(label );

    }


}
