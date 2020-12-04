package com.mikayelovich.part3.chapter10;

import org.apache.wicket.MarkupContainer;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.model.AbstractReadOnlyModel;


import java.text.DateFormat;
import java.util.Date;
import java.util.TimeZone;

public class Clock extends Label {
    private static class ClockModel extends AbstractReadOnlyModel {
        private DateFormat dateFormat;

        public ClockModel(TimeZone timeZone) {
            dateFormat = DateFormat.getDateTimeInstance(DateFormat.FULL, DateFormat.FULL);
            dateFormat.setTimeZone(timeZone);
        }

        @Override
        public Object getObject() {
            return dateFormat.format(new Date());
        }
    }

    public Clock(final String id, TimeZone tz) {
        super(id, new ClockModel(tz));
    }
}

