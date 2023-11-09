package com.tonnyseko.servlet.app.view.css;

import java.io.Serializable;

public class AppCss implements Serializable {

    private String style = "<style>" +
            ".topnav { " +
            "overflow: hidden;" +
            "background-color: #ddd;" +
            "padding: 20px;" +
            "display: flex;" +
            "flex-direction: row;" +
            "flex-wrap: wrap;" +
            "justify-content: space-between;" +
            "align-items: center;" +
            "}" +
            ".topnav a {" +
            "float: left;" +
            "color: black;" +
            "text-align: center;" +
            "padding: 14px 16px;" +
            "text-decoration: none;" +
            "font-size: 17px;" +
            "}" +
            ".topnav a:hover {" +
            "background-color: black;" +
            "color: #ddd;" +
            "}" +
            ".topnav a.active {" +
            "background-color: orange;" +
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
            "box-shadow: 0 0 10px 0 rgba0,0,0,0.2 +" +
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
            ".content {" +
            "padding: 16px;" +
            "display: flex;" +
            "flex-direction: row;" +
            "flex-wrap: wrap;" +
            "justify-content: center;" +
            "}" +
            "#add-event {" +
            "margin-top: -30px;" +
            "}" +

            "body {" +
            "    font-family: \"Arial\", sans-serif;" +
            "    background-color: #f2f2f2;" +
            "    text-align: center;" +
            "    height: 100vh;" +
            "}" +

            "input[type=text]," +
            "input[type=password] {" +
            "    width: 100%;" +
            "    padding: 12px 20px;" +
            "    margin: 8px 0;" +
            "    display: inline-block;" +
            "    border: 1px solid #ccc;" +
            "    border-radius: 4px;" +
            "    box-sizing: border-box;" +
            "}" +

            "button {" +
            "    background-color: #0077be;" +
            "    color: white;" +
            "    padding: 14px 20px;" +
            "    margin: 8px 0;" +
            "    border: none;" +
            "    border-radius: 4px;" +
            "    cursor: pointer;" +
            "    width: 100%;" +
            "}" +

            "button:hover {" +
            "    background-color: #005a8c;" +
            "}" +

            ".cancelbtn {" +
            "    padding: 10px 18px;" +
            "    background-color: #f44336;" +
            "}" +

            ".imgcontainer {" +
            "    text-align: center;" +
            "    margin: 24px 0 12px 0;" +
            "}" +

            "img.avatar {" +
            "    width: 100px;" +
            "    height: 100px;" +
            "    border-radius: 50%;" +
            "}" +

            ".container {" +
            "    background-color: #fff;" +
            "    padding: 16px;" +
            "    width: 50%;" +
            "    border-radius: 4px;" +
            "    margin: 0 auto;" +
            "    text-align: left;" +
            "}" +

            "h2 {" +
            "    color: #0077be;" +
            "    text-align: center;" +
            "}" +

            "span.psw {" +
            "    float: right;" +
            "    padding-top: 16px;" +
            "}" +

            "form {" +
            "    margin-top: 50px;" +
            "}" +

            ".login-form {" +
            "    display: block;" +
            "    margin: 0 auto;" +
            "    width: 50%;" +
            "}" +

            "@media screen and max-width: 300px) {" +
            "    span.psw {" +
            "        float: none;" +
            "    }" +

            "    .cancelbtn {" +
            "        width: 100%;" +
            "    }" +
            "}" +

            "</style>";

    public String getStyle() {
        return style;
    }

    public void setStyleString(String style) {
        this.style = style;
    }

}
