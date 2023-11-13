package com.tonnyseko.servlet.app.view.helper;

import com.tonnyseko.servlet.app.view.css.AppCss;


import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Serializable;

public class AppPage implements Serializable {
        public void renderHtml(HttpServletRequest req, HttpServletResponse res, int activeMenu, String content)
                        throws IOException {
                
                ServletContext context = req.getServletContext();
                PrintWriter print = res.getWriter();
                print.write("<!DOCTYPE html>" +
                        "<html>" +
                        "<head>" +
                        new AppCss().getStyle() +
                        "</head>" +
                        "<body>" +

                        new TopToolbar().menu(activeMenu) +

                        "<h3 class=\"app-name\">" + context.getInitParameter("AppName") + "<h3>");

                print.write("<div class=\"content\">" + content + "</div>");

                print.write(
                        "</body>" +
                                "</html>");
        }
}
