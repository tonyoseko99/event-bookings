package com.tonnyseko.servlet.app.action;

import com.tonnyseko.servlet.app.model.entity.Event;
import com.tonnyseko.servlet.app.model.entity.User;
import com.tonnyseko.servlet.app.view.helper.HtmlCpmRender;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang3.StringUtils;

import javax.servlet.http.HttpServlet;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Map;

public class BaseAction extends HttpServlet {
    @SuppressWarnings("unchecked")

    public <T> T serializeForm(T bean, Map<String, ? extends Object> requestMap) {
        // perform serialization
        try {
            BeanUtils.populate(bean, requestMap);
            return bean;
        } catch (IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        return null;
    }

    public void renderPage(HttpServletRequest request, HttpServletResponse response, int activeMenu,
            Class<?> entity, List<Event> entityList)
            throws ServletException, IOException {

        request.setAttribute("activeMenu", activeMenu);

        if (StringUtils.trimToEmpty(request.getParameter("action")).equals("add"))
            request.setAttribute("content", HtmlCpmRender.form(entity));
        else
            request.setAttribute("content", HtmlCpmRender.card(entityList));

        RequestDispatcher dispatcher = request.getRequestDispatcher("./app/index.jsp");
        dispatcher.forward(request, response);
    }
}
