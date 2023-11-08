package com.tonnyseko.servlet.app.view.toolbar;

import com.tonnyseko.servlet.app.model.view.MenuLink;
import com.tonnyseko.servlet.app.model.view.MenuLinkStatus;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class TopToolbar implements Menu, Serializable {
    private final List<MenuLink> links = new ArrayList<>();

    {
        links.add(new MenuLink("./home", "Home", MenuLinkStatus.ACTIVE));
        links.add(new MenuLink("./events", "Events", MenuLinkStatus.NOT_ACTIVE));
        links.add(new MenuLink("./categories", "Categories", MenuLinkStatus.NOT_ACTIVE));
        links.add(new MenuLink("./logout", "Logout", MenuLinkStatus.NOT_ACTIVE));
    }

    @Override
    public String menu(int activeLinkIndex){
        this.activateLink(activeLinkIndex);

        String menubar = "<div class=\"topnav\">";
        String leftMenu = "<div class=\"left\">";
        String rightMenu = "<div class=\"right\">";

        for(MenuLink link : links)
//            separate the logout link from the rest of the links using a div with class="right"
            if(link.getLabel().equals("Logout"))
                rightMenu += "<a href=\"" + link.getUrl() + "\" class=\"" + link.getStatus() + "\">" + link.getLabel() + "</a>";
            else
                leftMenu += "<a href=\"" + link.getUrl() + "\" class=\"" + link.getStatus() + "\">" + link.getLabel() + "</a>";

        leftMenu += "</div>";
        rightMenu += "</div>";

        menubar += leftMenu + rightMenu + "</div>";

        return menubar;
    }

    public void activateLink(int linkIndex){
        for(int index = 0; index<links.size(); index++){
            if(index == linkIndex)
                links.get(index).setStatus(MenuLinkStatus.ACTIVE);
            else
                links.get(index).setStatus(MenuLinkStatus.NOT_ACTIVE);
        }
    }
}
