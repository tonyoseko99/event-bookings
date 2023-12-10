package com.tonnyseko.servlet.app.helpers;

import com.tonnyseko.servlet.app.model.enums.CategoryStatus;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class TopToolbar implements Menu, Serializable {
    private int activeLinkIndex = 0;

    private final List<MenuLink> links = new ArrayList<>();

    {
        links.add(new MenuLink("./home", "Home", MenuLinkStatus.ACTIVE));
        links.add(new MenuLink("./events", "Events", MenuLinkStatus.NOT_ACTIVE));
        links.add(new MenuLink("./categories", "Categories", MenuLinkStatus.NOT_ACTIVE));
        links.add(new MenuLink("./reservations", "Reservations", MenuLinkStatus.NOT_ACTIVE));
        links.add(new MenuLink("./logout", "Logout", MenuLinkStatus.NOT_ACTIVE));
    }

    private final List<CategoryStatus> categories = new ArrayList<>();

    {
        categories.add(CategoryStatus.BUSINESS);
        categories.add(CategoryStatus.SPORTS);
        categories.add(CategoryStatus.TECHNOLOGY);
        categories.add(CategoryStatus.ENTERTAINMENT);
        categories.add(CategoryStatus.OTHER);
    }

    public int getActiveLinkIndex() {
        return activeLinkIndex;
    }

    public void setActiveLinkIndex(int activeLinkIndex) {
        this.activeLinkIndex = activeLinkIndex;
    }

    @Override
    public String menu(int activeLinkIndex) {
        this.activateLink(activeLinkIndex);

        StringBuilder menubar = new StringBuilder("<div class=\"topnav\">");
        StringBuilder leftMenu = new StringBuilder("<div class=\"left\">");
        StringBuilder rightMenu = new StringBuilder("<div class=\"right\">");

        for (MenuLink link : links) {
            // Separate the logout link from the rest of the links using a div with class="right"
            if (link.getLabel().equals("Logout")) {
                rightMenu.append("<a href=\"").append(link.getUrl()).append("\" class=\"").append(link.getStatus()).append("\">")
                        .append(link.getLabel()).append("</a>");
            } else if (link.getLabel().equals("Categories")) {
                leftMenu.append("<div class=\"dropdown\">");
                leftMenu.append("<button class=\"dropbtn\">").append(link.getLabel()).append("</button>");
                leftMenu.append("<div class=\"dropdown-content\">");

                leftMenu.append("<select onchange=\"location = this.value;\">");
                for (CategoryStatus category : categories) {
                    leftMenu.append("<option value=\"").append(link.getUrl()).append("?category=").append(category.name()).append("\">")
                            .append(category.name()).append("</option>");
                }
                leftMenu.append("</select>");

                leftMenu.append("</div>");
                leftMenu.append("</div>");
            } else {
                leftMenu.append("<a href=\"").append(link.getUrl()).append("\" class=\"").append(link.getStatus()).append("\">")
                        .append(link.getLabel()).append("</a>");
            }
        }

        leftMenu.append("</div>");
        rightMenu.append("</div>");

        menubar.append(leftMenu).append(rightMenu).append("</div>");

        return menubar.toString();
    }

    public void activateLink(int linkIndex) {
        for (int index = 0; index < links.size(); index++) {
            if (index == linkIndex)
                links.get(index).setStatus(MenuLinkStatus.ACTIVE);
            else
                links.get(index).setStatus(MenuLinkStatus.NOT_ACTIVE);
        }
    }
}
