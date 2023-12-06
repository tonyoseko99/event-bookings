<%@ page isELIgnored="false" %>
<%-- <%@ page import="com.tonnyseko.servlet.app.bean.EventBean" %>
<%@ page import="com.tonnyseko.servlet.app.model.Event" %>
<%@ page import="com.tonnyseko.servlet.app.view.helper.HtmlCpmRender" %> --%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.tonnyseko.servlet.app.view.helper.TopToolbar" %>


<!DOCTYPE html>
<html>

<head>
    <title>Events</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <!-- Bootstrap JavaScript -->
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
    <!-- Your other styles and scripts -->
    <%-- <jsp:include page="../style/style.jsp"></jsp:include> --%>
</head>

<body>
   <% TopToolbar toolbar = new TopToolbar(); %>
    <nav class="nav">
       <%= toolbar.menu((int) request.getAttribute("activeMenu")) %>
    </nav>

    <h3 class="app-name"><%= getServletContext().getInitParameter("AppName") %></h3>

    <div class="container">
       ${requestScope.content}
    </div>

</body>

</html>
