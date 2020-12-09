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
                    <td><c:out value="${s.category}" /></td>
                    <td><c:out value="${s.department}" /></td>
                    <td><c:out value="${s.startingDate}" /></td>
                    <td><c:out value="${s.closingDate}" /></td>
                     <td><c:out value="${s.description}" /></td>
                   <td>
                     
                         <a href="/Group1/ShowsServlet?action=UpdateShows&showsID=<c:out value='${s.showsID}' />">Update</a>
                        &nbsp;&nbsp;&nbsp;&nbsp;
                        <a onclick="del_confirm('Are you Sure want to delete the show <c:out value="${s.category}" />?','/Group1/ShowsServlet?action=deleteshows&showsID=<c:out value='${s.category}' />')" href="#">Delete</a> 
                        
                        
                    </td>
                </tr>
            </c:forEach>   
           
        </tr>
    </table>
</body>
</html>


