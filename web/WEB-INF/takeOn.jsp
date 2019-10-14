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
        <title>Take on book</title>
    </head>
    <body>
        <h1>Data </h1>
        
        <form action="createHistory" method="POST">
            <p>${info}</p>
            <h4>List of books </h4>
            <select name="bookId">
                <option value="" hidden="Choice">Empty</option>
                <c:forEach var="book" items="${listBooks}">
                    <option value="${book.id}">
                        Title: ${book.title}.
                        Author: ${book.author}.
                        Year ${book.year}. 
                        Quantity: ${book.quantity}</option>
                </c:forEach>

            </select></br>
            
            
            <h4>List of readers </h4>
            <select name="readerId">
                <option value="" hidden="Choice">Empty</option>
                <c:forEach var="reader" items="${listReaders}">
                    <option value="${reader.id}">
                        FirstName: ${reader.name}.
                        LastName: ${reader.lastname}
                        </option>
                </c:forEach>
            
            </select><br>
            <input type="submit" value="Book is taked"><br>
            <a href="index.jsp">Back </a><br>
        </form>
        
        
    </body>
</html>
