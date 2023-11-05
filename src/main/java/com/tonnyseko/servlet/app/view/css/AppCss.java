package com.tonnyseko.servlet.app.view.css;

import java.io.Serializable;

public class AppCss implements Serializable {

    private String style = "<style>" +
            ".topnav { " +
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
            ".card-section {" +
            "display: flex;" +
            "flex-direction: row;" +
            "flex-wrap: wrap;" +
            "justify-content: center;" +
            "}" +
            ".card-content {" +
            "padding: 20px;" +
            "margin: 20px;" +
            "width: 300px;" +
            "border: 1px solid #ccc;" +
            "box-shadow: 0 0 10px 0 rgba(0,0,0,0.2);" +
            "}" +
            ".card-content h2 {" +
            "text-align: center;" +
            "text-decoration: underline;" +
            "}" +
            ".main-page-feature {" +
            "margin-left: 30px;" +
            "margin-right: 30px;" +
            "display: flex;" +
            "flex-direction: row;" +
            "flex-wrap: wrap;" +
            "justify-content: center;" +
            "}" +
            ".main-page-feature img {" +
            "max-width: 100%;" +
            "max-height: 50vh;" +
            "}" +
            ".card-content p {" +
            "text-align: center;" +
            "}" +
            "form {" +
            "width: 100%;" +
            "max-width: 600px;" +
            "margin: 0 auto;" +
            "padding: 20px;" +
            "background-color: #f8f8f8;" +
            "border: 1px solid #ddd;" +
            "border-radius: 5px;" +
            "}" +
            "label {" +
            "display: block;" +
            "margin-bottom: 5px;" +
            "font-weight: bold;" +
            "}" +
            "input[type=\"text\"], input[type=\"date\"], input[type=\"time\"], input[type=\"number\"], textarea {" +
            "width: 100%;" +
            "padding: 10px;" +
            "margin-bottom: 20px;" +
            "border: 1px solid #ddd;" +
            "border-radius: 3px;" +
            "}" +
            "input[type=\"submit\"] {" +
            "padding: 10px 20px;" +
            "background-color: #007BFF;" +
            "color: white;" +
            "border: none;" +
            "border-radius: 3px;" +
            "cursor: pointer;" +
            "}" +
            "input[type=\"submit\"]:hover {" +
            "background-color: #0056b3;" +
            "}" +
            "</style>";

    public String getStyle() {
        return style;
    }

    public void setStyle(String style) {
        this.style = style;
    }
}
