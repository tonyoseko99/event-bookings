package com.tonnyseko.servlet.app.view.helper;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Serializable;

public class AppPage implements Serializable {
        public void renderHtml(HttpServletRequest req, HttpServletResponse res, int activeMenu, String content)
                throws IOException, ServletException {
                
                ServletContext context = req.getServletContext();
                // Set attributes for the JSP
                req.setAttribute("activeMenu", activeMenu);
                req.setAttribute("appName", context.getInitParameter("AppName"));
                req.setAttribute("content", content);

                // Forward the request to the JSP
                RequestDispatcher dispatcher = req.getRequestDispatcher("/index.jsp");
                dispatcher.forward(req, res);
        }
}
