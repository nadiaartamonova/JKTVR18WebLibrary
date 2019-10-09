<%-- 
    Document   : page1
    Created on : Sep 27, 2019, 10:59:53 AM
    Author     : Melnikov
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Book return</title>
    </head>
    <body>
        <h1>Data </h1>
        
        <form action="returnOnBook" method="POST">
            <p>${info}</p>
            
            
            
            <h4>List of history </h4>
            <select name="historyId">
                <option value="" hidden="Choice">Empty</option>
                <c:forEach var="history" items="${listHistories}">
                    <option value="${history.id}">
                        Title: ${history.book.title}.
                        Reader: ${history.reader.name} ${history.reader.lastname} 
                        
                        </option>
                </c:forEach>
            
            </select><br>
            <input type="submit" value="Book is returned"><br>
            <a href="index.html">Back </a><br>
        </form>
        
        
    </body>
</html>
