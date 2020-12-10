<%-- 
    Document   : UpdateShows
    Created on : 09-Dec-2020, 15:52:56
    Author     : gavok
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Update Show</title>
    </head>
    <body>
        <h1>Update Show</h1>
        <form action="ShowsServlet" method="GET" enctype="multipart/form-data">
            <input type="hidden" name="action" value="saveShow">
            
            <input type="hidden" name="showsID" value=<c:out value='${shows.showsID}' />>
            
            <label for="category">category:</label>
            <input type="text" id="category" name="category" value=<c:out value='${shows.category}' />><br>

            <label for="department">department:</label>
            <input type="text" id="department" name="department" value=<c:out value='${shows.department}' />><br>

            <label for="startingDate">startingDate:</label>
            <input type="date" id="startingDate" name="startingDate" value="<c:out value='${shows.startingDate}' />"><br>

            <label for="closingDate">closingDate:</label>
            <input type="date" id="closingDate" name="closingDate" value="<c:out value='${shows.closingDate}' />"><br>
           
            <label for="desciption">description</label>
            <input type="text" id="description" name="description"><br>





            <input type="submit" value="Submit">

        </form>
    </body>
</html>
