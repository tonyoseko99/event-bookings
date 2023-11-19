package com.tonnyseko.servlet.app.utils;

import com.tonnyseko.servlet.app.view.helper.HtmlCard;
import com.tonnyseko.servlet.app.view.helper.HtmlForm;
import com.tonnyseko.servlet.app.view.helper.HtmlFormField;

import java.lang.reflect.Field;

public class AnnotationsPreProcessor {
    public static String processHtmlFormAnnotations(Class<?> clazz) {
        HtmlForm htmlFormAnnotation = clazz.getAnnotation(HtmlForm.class);
        if (htmlFormAnnotation != null) {
            String label = htmlFormAnnotation.label();
            String url = htmlFormAnnotation.url();
            String httpMethod = htmlFormAnnotation.httpMethod();
            return "<form action=\"" + url + "\" method=\"" + httpMethod + "\">" +
                    "<label>" + label + "</label>";
        }
        return "";
    }

    public static String processHtmlFormFieldAnnotations(Field field) {
        HtmlFormField htmlFormFieldAnnotation = field.getAnnotation(HtmlFormField.class);
        if (htmlFormFieldAnnotation != null) {
            String labelFor = htmlFormFieldAnnotation.labelFor();
            String label = htmlFormFieldAnnotation.label();
            String id = htmlFormFieldAnnotation.id();
            String name = htmlFormFieldAnnotation.name();
            return "<li id=\"" + id + "\">" +
                    "<label for=\"" + labelFor + "\">" + label + "</label>" +
                    "<input type=\"text\" name=\"" + name + "\">" +
                    "</li>";
        }
        return "";
    }

    public static String processHtmlCardAnnotations(Class<?> clazz) {
        HtmlCard htmlCardAnnotation = clazz.getAnnotation(HtmlCard.class);
        if (htmlCardAnnotation != null) {
            String url = htmlCardAnnotation.url();
            String title = htmlCardAnnotation.title();
            return "<div class=\"card\" title=\"" + title + "\"><a href=\"" + url + "\">View Card</a></div>";
        }
        return "";
    }
}
