package com.mikayelovich.part2.chapter5.repeaters.menu;

import com.mikayelovich.part2.chapter5.ParameterizedPage;
import com.mikayelovich.part2.chapter5.TestPage;
import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.link.BookmarkablePageLink;
import org.apache.wicket.markup.repeater.RepeatingView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MenuPage extends WebPage {

    private List<MenuItem> menuItemList = Arrays.asList(new MenuItem("Test page", TestPage.class),
            new MenuItem("Parameterized Page", ParameterizedPage.class),
            new MenuItem("Menu Page", MenuPage.class));
    public MenuPage() {
        RepeatingView repeatingView = new RepeatingView("menu");
        add(repeatingView);
        for (MenuItem item : menuItemList) {
            WebMarkupContainer container = new WebMarkupContainer(repeatingView.newChildId());
            System.out.println("Container ID: " + container.getId());
            repeatingView.add(container);
            BookmarkablePageLink link = new BookmarkablePageLink("link", item.getDestination());
            container.add(link);
            link.add(new Label("caption", item.getCaption()));
        }
    }
}
