package com.tonnyseko.servlet.app.view.helper;

import com.tonnyseko.servlet.app.view.css.AppCss;
import com.tonnyseko.servlet.app.view.toolbar.TopToolbar;

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


        }
}
