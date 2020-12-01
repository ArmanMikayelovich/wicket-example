package com.mikayelovich.cheesr.pages;

import com.mikayelovich.cheesr.model.Cheese;
import com.mikayelovich.cheesr.panel.ShoppingCartPanel;
import org.apache.wicket.behavior.HeaderContributor;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.Button;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.ListView;
import org.apache.wicket.markup.html.list.PageableListView;
import org.apache.wicket.markup.html.navigation.paging.PagingNavigator;
import org.apache.wicket.model.Model;
import org.apache.wicket.model.PropertyModel;

import java.text.NumberFormat;

public class Index extends CheesrHomePage {
    public Index() {
        add(HeaderContributor.forCss(Index.class, "style.css"));
        final PageableListView cheesesListView = getCheesesListView();

        add(cheesesListView);
        add(new PagingNavigator("navigator", cheesesListView));
        add(new ShoppingCartPanel("shoppingcart", getCart()));
        add(new Link("checkout") {
            @Override
            public void onClick() {
                setResponsePage(new CheckoutPage());
            }

            @Override
            public boolean isVisible() {
                return !getCart().getCheeses().isEmpty();            }
        });
    }

    private PageableListView getCheesesListView() {
        return new PageableListView("cheeses", getCheeses(),5) {
            @Override
            protected void populateItem(ListItem item) {
                Cheese cheese = (Cheese) item.getModelObject();
                item.add(new Label("name", cheese.getName()));
                item.add(new Label("description", cheese.getDescription()));
                item.add(new Label("price", "$" + cheese.getPrice()));
                item.add(new Link("add", item.getModel()) {
                    @Override
                    public void onClick() {
                        Cheese selected = (Cheese) getModelObject();
                        getCart().getCheeses().add(selected);
                    }
                });
            }
        };
    }

}
