package com.mikayelovich.part1.cheesr.pages;

import com.mikayelovich.part1.cheesr.CheesrApplication;
import com.mikayelovich.part1.cheesr.model.Cart;
import com.mikayelovich.part1.cheesr.model.Cheese;
import com.mikayelovich.part1.cheesr.session.CheesrSession;
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
