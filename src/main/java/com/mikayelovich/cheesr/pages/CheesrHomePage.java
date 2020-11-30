package com.mikayelovich.cheesr.pages;

import com.mikayelovich.cheesr.CheesrApplication;
import com.mikayelovich.cheesr.model.Cart;
import com.mikayelovich.cheesr.model.Cheese;
import com.mikayelovich.cheesr.session.CheesrSession;
import org.apache.wicket.markup.html.WebPage;

import java.util.List;

public class CheesrHomePage extends WebPage {
    public CheesrHomePage() {
    }

    public CheesrSession getCheesrSession() {
        return (CheesrSession) getSession();
    }

    public Cart getCart() {
        return getCheesrSession().getCart();
    }

    public List<Cheese> getCheeses() {
        return CheesrApplication.get().getCheeses();
    }
}
