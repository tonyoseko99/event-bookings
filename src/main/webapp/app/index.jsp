<%@ page isELIgnored="false" %>
<%@ page import="com.tonnyseko.servlet.app.bean.EventBean" %>
<%@ page import="com.tonnyseko.servlet.app.model.Event" %>
<%@ page import="com.tonnyseko.servlet.app.view.helper.HtmlCpmRender" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.tonnyseko.servlet.app.view.helper.TopToolbar" %>


<!DOCTYPE html>
<html>

<head>
    <title>Events</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <jsp:include page="../style/style.jsp"></jsp:include>
</head>

<body>



    <h1><%= getServletContext().getInitParameter("AppName") %></h1>

    <h3 class="app-name"><%= getServletContext().getInitParameter("AppName") %></h3>

    <div class="content">
        <%-- Render card based on events list --%>
       ${requestScope.content}

    </div>

</body>

</html>
