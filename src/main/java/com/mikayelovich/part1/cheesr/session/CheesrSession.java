package com.mikayelovich.part1.cheesr.session;

import com.mikayelovich.part1.cheesr.model.Cart;
import lombok.Getter;
import org.apache.wicket.Request;
import org.apache.wicket.protocol.http.WebSession;

public class CheesrSession extends WebSession {
    @Getter
    private Cart cart = new Cart();

    public CheesrSession(Request request) {
        super(request);
    }

}
