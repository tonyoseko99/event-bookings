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

        String menubar = "<div class=\"topnav\">";
        String leftMenu = "<div class=\"left\">";
        String rightMenu = "<div class=\"right\">";

        for (MenuLink link : links)
            // separate the logout link from the rest of the links using a div with
            // class="right"
            if (link.getLabel().equals("Logout"))
                rightMenu += "<a href=\"" + link.getUrl() + "\" class=\"" + link.getStatus() + "\">" + link.getLabel()
                        + "</a>";
            else if (link.getLabel().equals("Categories")) {
                leftMenu += "<div class=\"dropdown\">";
                leftMenu += "<button class=\"dropbtn\">" + link.getLabel() + "</button>";
                leftMenu += "<div class=\"dropdown-content\">";

                for (CategoryStatus category : categories)
                    leftMenu += "<a href=\"" + link.getUrl() + "?category=" + category.name() + "\">" + category.name()
                            + "</a>";

                leftMenu += "</div>";
                leftMenu += "</div>";
            } else {

                leftMenu += "<a href=\"" + link.getUrl() + "\" class=\"" + link.getStatus() + "\">" + link.getLabel()
                        + "</a>";
            }

        leftMenu += "</div>";
        rightMenu += "</div>";

        menubar += leftMenu + rightMenu + "</div>";

        return menubar;
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

