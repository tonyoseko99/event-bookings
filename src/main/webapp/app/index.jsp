<%@ page isELIgnored="false" %>
<%@ page isELIgnored="false" %>
<%@ page import="com.tonnyseko.servlet.app.helpers.TopToolbar" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>

<head>
   <style>
      <jsp:include page="../style/style.jsp" />
   </style>
</head>

<body>
   <% TopToolbar toolbar = new TopToolbar(); %>
   
   <%= toolbar.menu((int) request.getAttribute("activeMenu")) %>

   <%-- logged in as --%>
   <div class="logged-in-as">
      <c:if test="${not empty sessionScope.username}">
         <span>Logged in as: ${sessionScope.username}</span>
      </c:if>
   </div>
   

   
      ${requestScope.content}
   

</body>

</html>
