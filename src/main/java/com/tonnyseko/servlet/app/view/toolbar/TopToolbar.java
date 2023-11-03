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

        for(MenuLink link : links)
            menubar += "<a " + (link.getStatus() == MenuLinkStatus.ACTIVE? "class=\"active\"" : "")
                    + " href=\"" + link.getUrl() + "\">" + link.getLabel() + "</a>";
        menubar += "</div>";
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
