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

        "table {" +
            "font-family: Arial, sans-serif;" +
            "border-collapse: collapse;" +
            "width: 100%;" +
        "}" +

        "td, th {" +
            "border: 1px solid #dddddd;" +
            "text-align: left;" +
            "padding: 8px;" +
        "}" +

        "tr:nth-child(even) {" +
            "background-color: #f2f2f2;" +
        "}" +

        ".card-section {" +
            "padding: 2px 16px;" +
            "display: flex;" +
            "flex-direction: row;" +
            "justify-content: center;" +
            "align-items: center;" +
            "flex-wrap: wrap;" +
            "margin: 0 auto;" +
            "width: 100%;" +
            "max-width: 1200px;" +
            "box-sizing: border-box;" +
        "}" +

        ".card {" +
            "box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.2);" +
            "max-width: 300px;" +
            "margin: auto;" +
            "text-align: center;" +
            "font-family: Arial, sans-serif;" +
        "}" +

        ".card-content {" +
            "padding: 2px 16px;" +
        "}" +

        "</style>";

    public String getStyle() {
        return style;
    }

    public void setStyle(String style) {
        this.style = style;
    }
}
