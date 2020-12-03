package com.mikayelovich.part2.chapter5;

import com.mikayelovich.part2.chapter5.attributes.StylingPage;
import com.mikayelovich.part2.chapter6.forms.FormExamples;
import com.mikayelovich.part2.chapter5.repeaters.RepeatComponentsPage;
import com.mikayelovich.part2.chapter5.repeaters.menu.MenuPage;
import org.apache.wicket.PageParameters;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.basic.MultiLineLabel;
import org.apache.wicket.markup.html.link.BookmarkablePageLink;
import org.apache.wicket.markup.html.link.ExternalLink;

public class TestPage extends WebPage {
    public TestPage() {
        add(new BookmarkablePageLink("chapter8", com.mikayelovich.part3.chapter9.TestPage.class));

        add(new Label("simpleLabel", "first text"));
        add(new MultiLineLabel("multilineLabel", "Fusce vel congue dui, quis egestas eros. Donec luctus bibendum purus.\n" +
                " Mauris non nisi in neque porta consequat.\n" +
                " Suspendisse rhoncus nec ex eu efficitur.\n" +
                " Duis ac lorem ac ex tristique imperdiet\n" +
                " Duis id efficitur urna.\n" +
                " Pellentesque elementum nisl quis porta pretium.\n" +
                " Sed commodo venenatis purus nec fermentum. \n" +
                "Integer aliquet purus non pulvinar auctor.\n" +
                " Maecenas vel sagittis mi. Sed molestie eros et bibendum sollicitudin."));

        add(new MultiLineLabel("formattedLabel", "Fusce vel congue dui, quis egestas eros.<br/>" +
                " Donec luctus<b> bibendum</b> purus.\n" +
                " Mauris non nisi in neque porta consequat.\n" +
                " Suspendisse rhoncus nec ex eu efficitur.\n" +
                " Duis ac<b> lorem ac ex tristique imperdiet\n" +
                " Duis id efficitur urna.\n" +
                " Pellentesque elementum</b> nisl quis porta pretium.\n" +
                " Sed commodo venenatis purus nec fermentum. \n" +
                "Integer aliquet purus non pulvinar auctor.\n" +
                " Maecenas vel sagittis mi. Sed molestie eros et bibendum sollicitudin.").setEscapeModelStrings(false));

        add(new MultiLineLabel("attackXSS", "<script>alert(\" hello, xss worlds\") </script> " +
                "This text will call alert function in browser")
                .setEscapeModelStrings(false));

        add(new ExternalLink("repeatsPage", urlFor(RepeatComponentsPage.class,PageParameters.NULL).toString(),"Repeat page"));

        add(new ExternalLink("externalLink", getURI(), "go to parameterized page"));
        add(new BookmarkablePageLink("menuLink", MenuPage.class));
        add(new BookmarkablePageLink("StyledPage", StylingPage.class));
        add(new BookmarkablePageLink("formPage", FormExamples.class));


    }

    private String getURI() {
        return urlFor(ParameterizedPage.class, getMockParameters()).toString();
    }

    private PageParameters getMockParameters() {
        PageParameters pageParameters = new PageParameters();
        pageParameters.put("firstKey", "firstValue");
        pageParameters.put("secondKey", "secondValue");
        return pageParameters;
    }


}
