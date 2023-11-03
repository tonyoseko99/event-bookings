package com.tonnyseko.servlet.app.view.html;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Serializable;

public class AppPage implements Serializable {
    public void renderHtml(HttpServletRequest req, HttpServletResponse res int activeMenu, String content) throws IOException{
        HttpSession session = req.getSession();
        ServletContext context = req.getServletContext();
        PrintWriter print = res.getWriter();

        print.write("<DOCTYPE html>" +
                "<html>" +
                "<head>" +
                    new AppCss().getStyle() +
                "</head>" +
                "<body>" +

                new TopToolbar().menu(activeMenu) +

                "<h3>" + context.getInitParameter("AppName") + "<h3>" +
                "<br/>&nbsp;<br/>" +
                "<h3>Welcome: " + session.getAttribute("username") + "</h3><br/>");
        print.write(content);
        print.write("<a href=\"./logout\">Logout</a>" +
                "</body>" +
                "</html>");
    }
}
