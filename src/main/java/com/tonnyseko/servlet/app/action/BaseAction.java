package com.tonnyseko.servlet.app.action;

import com.tonnyseko.servlet.app.model.entity.Event;
import com.tonnyseko.servlet.app.helpers.HtmlCpmRender;

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
                String[] parts = key.split("\\.");
                Field field;
                try {
                    field = entity.getDeclaredField(key);
                } catch (NoSuchFieldException e) {
                    continue;
                }
                field.setAccessible(true);
                setFieldValue(field, object, values[0]);

                if (parts.length > 1) {
                    // The field is part of an embedded object
                    String objectName = parts[0];
                    String fieldName = parts[1];

                    Field objectField = entity.getDeclaredField(objectName);
                    objectField.setAccessible(true);
                    Object embeddedObject = objectField.get(object);

                    // If the embedded object is null, instantiate it
                    if (embeddedObject == null) {
                        embeddedObject = objectField.getType().getDeclaredConstructor().newInstance();
                    }

                    Field embeddedField = embeddedObject.getClass().getDeclaredField(fieldName);
                    embeddedField.setAccessible(true);
                    setFieldValue(embeddedField, embeddedObject, values[0]);

                    objectField.set(object, embeddedObject);
                }
            }
            return object;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    private void setFieldValue(Field field, Object object, String value) throws IllegalAccessException, ParseException {
        if (field.getType().equals(Date.class)) {
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            Date date = format.parse(value);
            field.set(object, date);
        } else if (field.getType().equals(Time.class)) {
            SimpleDateFormat format = new SimpleDateFormat("HH:mm");
            Date date = format.parse(value);
            Time time = new Time(date.getTime());
            field.set(object, time);
        } else if (field.getType().isEnum()) {
            field.set(object, Enum.valueOf((Class<Enum>) field.getType(), value));
        } else {
            field.set(object, value);
        }
    }

    public <T> void renderPage(HttpServletRequest request, HttpServletResponse response, int activeMenu,
            Class<?> entity, List<T> entityList)
            throws ServletException, IOException {

        request.setAttribute("activeMenu", activeMenu);

        if (StringUtils.trimToEmpty(request.getParameter("action")).equals("add")) {
            request.setAttribute("content", HtmlCpmRender.form(entity));
        } else if (StringUtils.trimToEmpty(request.getParameter("action")).equals("rsvp")) {
            String eventId = request.getParameter("event_id");
            String userId = request.getParameter("user_id");

            request.setAttribute("content", HtmlCpmRender.form(entity, eventId, userId));
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
