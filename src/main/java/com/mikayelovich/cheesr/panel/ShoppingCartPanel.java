package com.mikayelovich.cheesr.panel;

import com.mikayelovich.cheesr.model.Cart;
import com.mikayelovich.cheesr.model.Cheese;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.ListView;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.Model;
import org.apache.wicket.model.PropertyModel;

import java.text.NumberFormat;

public class ShoppingCartPanel extends Panel {
    private Cart cart;

    public ShoppingCartPanel(String id, Cart cart) {
        super(id);
        this.cart = cart;

        add(new ListView("cart", new PropertyModel(this, "cart.cheeses")) {
            @Override
            protected void populateItem(ListItem item) {
                final Cheese cheese = (Cheese) item.getModelObject();
                item.add(new Label("name", cheese.getName()));
                item.add(new Label("description", cheese.getDescription()));
                item.add(new Label("price", "$" + cheese.getPrice()));
                item.add(new Link("remove", item.getModel()) {
                    @Override
                    public void onClick() {
                        Cheese selected = (Cheese) getModelObject();
                        getCart().getCheeses().remove(selected);
                    }
                });
            }
        });

        add(new Label("total", new Model() {
            @Override
            public Object getObject() {
                NumberFormat nf = NumberFormat.getCurrencyInstance();
                return nf.format(getCart().getTotal());
            }
        }));
    }

    private Cart getCart() {
        return this.cart;
    }


}
