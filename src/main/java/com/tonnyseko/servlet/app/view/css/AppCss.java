package com.tonnyseko.servlet.app.view.css;

import java.io.Serializable;

public class AppCss implements Serializable {

    private String style = "<style>" +

        ".topnav {" +
            "overflow: hidden;" +
            "background-color: #333;" +
        "}" +

        ".topnav a {" +
            "float: left;" +
            "color: #f2f2f2;" +
            "text-align: center;" +
            "padding: 14px 16px;" +
            "text-decoration: none;" +
            "font-size: 17px;" +
        "}" +

        ".topnav a:hover {" +
            "background-color: #ddd;" +
            "color: black;" +
        "}" +

        ".topnav a.active {" +
            "background-color: #04AA6D;" +
            "color: white;" +
        "}" +

        ".card {" +
            "box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.2);" +
            "max-width: 300px;" +
            "margin: auto;" +
            "text-align: center;" +
            "font-family: Arial, sans-serif;" +
            "background-color: #f1f1f1;" +
            "border-radius: 5px;" +
            "padding: 10px;" +
            "display: flex;" +
            "flex-direction: row;" +
            "justify-content: center;" +
            "align-items: center;" +
            "margin-bottom: 10px;" +
            "margin-top: 10px;" +
            
        "}" +

        ".card-content {" +
            "padding: 2px 16px;" +
        "}" +
        ".app-name {" +
            "text-align: center;" +
            "font-family: Arial, sans-serif;" +
            "font-size: 30px;" +
            "color: #04AA6D;" +
            "font-weight: bold;" +
        "}" +

        "</style>";

    public String getStyle() {
        return style;
    }

    public void setStyle(String style) {
        this.style = style;
    }
}
