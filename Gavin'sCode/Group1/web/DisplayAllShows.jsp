<%-- 
    Document   : DisplayAllShows
    Created on : 07-Dec-2020, 20:58:47
    Author     : gavok
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<script>  function del_confirm(msg,url)
        {
            if(confirm(msg))
            {
                window.location.href=url;
            }
            else
            {
                false;
            }

        }  </script>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <style>
            table, th, td {
                border: 1px solid black;
                border-collapse: collapse;
            }
            th, td {
                padding: 5px;
                text-align: left;
            }
        </style>
    </head>
    <body>
        <h1>Display All shows</h1>
        <c:out value="${message}" />
        <a href="/Group1/ShowsServlet?action=home">Home Page</a>
         <form action="ShowsServlet" method="get">
        
         <br>
         
         </form>
        <table>
            <tr>
                <th>category</th>
                <th>department</th>
                <th>startingDate</th>
                <th>closingDate</th>
                <th>description</th>
               
            </tr>
            <tr>
                <c:forEach var="s" items="${Allshows}">
                <tr>
                    <td><c:out value="${s.Category}" /></td>
                    <td><c:out value="${s.Department}" /></td>
                    <td><c:out value="${s.StartingDate}" /></td>
                    <td><c:out value="${s.ClosingDate}" /></td>
                     <td><c:out value="${s.Description}" /></td>
                   <td>
                     
                        
                        
                    </td>
                </tr>
            </c:forEach>   
           
        </tr>
    </table>
</body>
</html>


