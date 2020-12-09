<%-- 
    Document   : Home
    Created on : 07-Dec-2020, 20:47:57
    Author     : gavok
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Welcome to NavyWorks</h1>
    </body>
    
   
    <form action="ShowsServlet" method="get">
         <input type="hidden" name="action" value="RequestAddShows">
         <input type="submit" value="shows" >
         <br>
         
    </form>
    
    <c:out value="${message}" />
</html>


