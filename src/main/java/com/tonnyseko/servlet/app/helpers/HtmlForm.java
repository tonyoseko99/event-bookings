package com.tonnyseko.servlet.app.helpers;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface HtmlForm {
    String label();

    String url();

    String httpMethod() default "POST";
}

