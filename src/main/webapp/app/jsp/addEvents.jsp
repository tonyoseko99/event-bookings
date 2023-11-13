<%@ page import=com.tonnyseko.servlet.app.model.view.CategoryStatus %>
<%@ page import=com.tonnyseko.servlet.app.view.helper.TopToolbar %>
<!DOCTYPE html>
<html>

<head>
    <style>
        <%@ include file=../style/style.jsp %>
    </style>
</head>

<body>

<%= new TopToolbar().menu((int)request.getAttribute(activeMenu)) %>

<h1>${pageContext.servletContext.getInitParameter(AppName)}</h1>

<h3 class=app-name>${pageContext.servletContext.getInitParameter(AppName)}</h3>

<form method='post' action='./events'>
    <label for='event_name'>Event Name:</label><br>
    <input type='text' id='event_name' name='event_name'><br>
    <label for='event_image'>Event Image:</label><br>
    <input type='text' id='event_image' name='event_image'><br>
    <label for='event_date'>Event Date:</label><br>
    <input type='date' id='event_date' name='event_date'><br>
    <label for='event_location'>Event Location:</label><br>
    <input type='text' id='event_location' name='event_location'><br>
    <label for='event_time'>Event Time:</label><br>
    <input type='time' id='event_time' name='event_time'><br>
    <label for='event_category'>Event Category:</label><br>
    <select id='event_category' name='event_category'>
        <option value='TECH'>Tech</option>
        <option value='BUSINESS'>Business</option>
        <option value='SPORTS'>Sports</option>
        <option value='ENTERTAINMENT'>Entertainment</option>
        <option value='OTHER'>Other</option>
    </select><br>
    <label for='event_description'>Event Description:</label><br>
    <textarea id='event_description' name='event_description'></textarea><br><br>
    <input type='submit' value='Add Event'>
</form>
<br><br>
<button class='btn btn-primary' id='back'><a href='./events'>Back</a></button>

</body>

</html>
