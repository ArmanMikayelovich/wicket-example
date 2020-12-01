package com.mikayelovich.part2.chapter4.tests.model;

import com.mikayelovich.part1.cheesr.model.Cheese;
import com.mikayelovich.part2.chapter4.tests.dao.CheeseDao;
import org.apache.wicket.model.LoadableDetachableModel;

public class LoadableCheeseModel extends LoadableDetachableModel {

    private CheeseDao cheeseDao = new CheeseDao();
    private Integer id;

    public LoadableCheeseModel(Integer id) {
        this.id = id;
    }

    @Override
    protected Object load() {
        if (id == null) {
            return new Cheese("null", "null", 1.2);
        }
        return cheeseDao.getById(id);
    }
}
