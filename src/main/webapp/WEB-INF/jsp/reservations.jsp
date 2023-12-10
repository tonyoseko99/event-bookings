<%@ page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.tonnyseko.servlet.app.helpers.TopToolbar" %>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
    <title>Reservations</title>
</head>
<body>
<% TopToolbar toolbar = new TopToolbar(); %>
<nav class="nav">
    <%= toolbar.menu((int) request.getAttribute("activeMenu")) %>
</nav>
<h1>Reservations</h1>
<table>
    <tr>
        <th>Reservation ID</th>
        <th>Customer Name</th>
        <th>Reservation Date</th>
        <th>Reservation Time</th>
        <th>Event Name</th>
    </tr>
    <c:forEach var="reservation" items="${reservations}">
        <tr>
            <td>${reservation.id}</td>
            <td>${reservation.name}</td>
            <td>${reservation.reservationDate}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
