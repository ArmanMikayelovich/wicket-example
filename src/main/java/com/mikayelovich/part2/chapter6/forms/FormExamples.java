package com.mikayelovich.part2.chapter6.forms;

import com.mikayelovich.part2.chapter4.form.Customer;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.form.DropDownChoice;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.ListChoice;
import org.apache.wicket.markup.html.form.RadioChoice;
import org.apache.wicket.model.PropertyModel;

import java.util.Arrays;
import java.util.List;

public class FormExamples extends WebPage {
    Customer customer = new Customer();
    List<String> categories = Arrays.asList("Fresh", "Whey",
            "Goat or sheep", "Hard", "Blue vein");

    public FormExamples() {
        Form form = new Form("form");
        add(form);

        form.add(new ListChoice("select", categories) {
            @Override
            protected void onModelChanged() {
                System.out.println("model changed");
            }
        });
        form.add(new DropDownChoice("selectDropDown", categories) {
            @Override
            protected void onModelChanged() {
                System.out.println("model changed");
            }
        });

        form.add(new RadioChoice("radio", new PropertyModel(customer, "name"),categories));
    }
}
