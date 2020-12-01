package com.mikayelovich.part2.chapter4.tests.model;

import com.mikayelovich.part1.cheesr.model.Cheese;
import org.apache.wicket.model.Model;

public class CheeseModel extends Model {
    private String id;

    private transient Cheese cheese;

    @Override
    public Object getObject() {
        if (cheese != null) {
            return cheese;

        }
        if (id != null) {
            Cheese cheese = new Cheese("" + id, "desc", 4.5);
            return cheese;
        } else {
            return new Cheese(null, "cheese with no name\\id", 0D);
        }

    }

    @Override
    public void setObject(Object object) {
        if (object instanceof Cheese) {
            cheese = (Cheese) object;
            if (cheese.getName() != null) {
                this.id = cheese.getName();
            }
        }
    }

    @Override
    public void detach() {
        this.cheese = null;
    }
}
