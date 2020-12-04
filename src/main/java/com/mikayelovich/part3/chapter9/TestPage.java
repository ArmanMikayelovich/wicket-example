package com.mikayelovich.part3.chapter9;

import com.mikayelovich.part3.Part3Application;
import org.apache.wicket.RequestCycle;
import org.apache.wicket.ResourceReference;
import org.apache.wicket.SharedResources;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.WebResource;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.SubmitLink;
import org.apache.wicket.markup.html.image.Image;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.markup.html.link.ResourceLink;
import org.apache.wicket.protocol.http.WebResponse;
import org.apache.wicket.request.target.resource.ResourceStreamRequestTarget;
import org.apache.wicket.util.resource.IResourceStream;
import org.apache.wicket.util.resource.StringResourceStream;

import java.util.Arrays;
import java.util.List;

public class TestPage extends WebPage {
   static List<Discount> discountList = Arrays.asList(new Discount("macarelo", 20.5),
            new Discount("chanax", 10D),
            new Discount("lori", 25D));

    public TestPage() {
        Link link = new Link("clickMe") {
            @Override
            public void onClick() {
                System.out.println("Clicked!!");

            }
        };

        Link deleteLink = new Link("deleteMe") {
            @Override
            public void onClick() {
                System.out.println("Clicked!!");

            }
        };
        link.add(new Image("clickIcon", new ResourceReference(TestPage.class, "click.png")));
        add(link);
        add(deleteLink);
        deleteLink.add(new Image("deleteIcon", new ResourceReference(TestPage.class, "trash.png")));


        WebResource export = getWebResource();
        export.setCacheable(false);

        SharedResources sharedResources = Part3Application.get().getSharedResources();
        sharedResources.add("discounts", export);


        ResourceReference discountsReference = new ResourceReference("discounts");
        ResourceLink discountsLink = new ResourceLink("discountsLink", discountsReference);
        discountsLink.add(new Image("downloadIcon", new ResourceReference(TestPage.class, "download.png")));
        add(discountsLink);

        add(getDownloadForm());
    }

    private Form getDownloadForm() {
        Form form = new Form("exportForm");
        form.add(new SubmitLink("exportSubmitLink") {
            @Override
            public void onSubmit() {
                CharSequence discounts = TestPage.getDiscounts();
                ResourceStreamRequestTarget target =
                        new ResourceStreamRequestTarget(new StringResourceStream(discounts, "text/csv"));
                target.setFileName("discounts");
                RequestCycle.get().setRequestTarget(target);
            }
        });
        return form;
    }



    private WebResource getWebResource() {
        return new WebResource() {

            @Override
            public IResourceStream getResourceStream() {
                return new StringResourceStream(getDiscounts(), "text/csv");
            }

            @Override
            protected void setHeaders(WebResponse response) {
                super.setHeaders(response);
                response.setAttachmentHeader("discounts.csv");
            }
        };
    }

    public static CharSequence getDiscounts() {
        StringBuilder b = new StringBuilder();
        for (Discount discount : discountList) {
            b.append(discount.getCheeseName()).append(',');
            b.append(discount.getPercent()).append('\n');
        }
        return b;
    }
}
