package com.tonnyseko.servlet.app.action;

import com.tonnyseko.servlet.app.model.entity.Event;
import com.tonnyseko.servlet.app.helpers.HtmlCpmRender;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang3.StringUtils;

import javax.servlet.http.HttpServlet;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Field;
import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

public class BaseAction extends HttpServlet {
    public <T> T serializeForm(Class<T> entity, Map<String, String[]> parameterMap) {
        try {
            T object = entity.getDeclaredConstructor().newInstance();
            for (Map.Entry<String, String[]> entry : parameterMap.entrySet()) {
                String key = entry.getKey();
                String[] values = entry.getValue();
                Field field = entity.getDeclaredField(key);
                if (field.getType().equals(Date.class)) {
                    SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
                    try {
                        Date date = format.parse(values[0]);
                        field.setAccessible(true);
                        field.set(object, date);
                    } catch (ParseException e) {
                        // Handle parsing error
                        e.printStackTrace();
                    }
                } else if (field.getType().equals(Time.class)) {
                    SimpleDateFormat format = new SimpleDateFormat("HH:mm"); // line 44
                    try {
                        Date date = format.parse(values[0]);
                        Time time = new Time(date.getTime());
                        field.setAccessible(true);
                        field.set(object, time);
                    } catch (ParseException e) {
                        // Handle parsing error
                        e.printStackTrace();
                    }
                } else if(field.getType().isEnum()) {
                    field.setAccessible(true);
                    field.set(object, Enum.valueOf((Class<Enum>) field.getType(), values[0]));
                } else {
                    field.setAccessible(true);
                    field.set(object, values[0]);
                }
            }
            return object;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

//    public <T> T serializeForm(Class<T> entity, Map<String, String[]> parameterMap) {
//        try {
//            T object = entity.getDeclaredConstructor().newInstance();
//            BeanUtils.populate(object, parameterMap);
//            return object;
//        } catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
//            e.printStackTrace();
//        }
//        return null;
//    }

    public <T> void renderPage(HttpServletRequest request, HttpServletResponse response, int activeMenu,
                           Class<?> entity, List<T> entityList)
            throws ServletException, IOException {

        request.setAttribute("activeMenu", activeMenu);

        if (StringUtils.trimToEmpty(request.getParameter("action")).equals("add")) {
            request.setAttribute("content", HtmlCpmRender.form(entity));
        } else if(StringUtils.trimToEmpty(request.getParameter("action")).equals("rsvp")) {
            request.setAttribute("content", HtmlCpmRender.form(entity));
        } // render the table if the path is /reservations
        else if (StringUtils.trimToEmpty(request.getServletPath()).equals("/reservations")) {
            request.setAttribute("content", HtmlCpmRender.table(entityList));
        } else {
            request.setAttribute("content", HtmlCpmRender.card((List<Event>) entityList));
        } 

        RequestDispatcher dispatcher = request.getRequestDispatcher("/app/index.jsp");
        dispatcher.forward(request, response);
    }
}
