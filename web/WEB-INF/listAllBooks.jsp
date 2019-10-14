<%-- 
    Document   : listAllBooks
    Created on : Oct 9, 2019, 9:19:23 AM
    Author     : pupil
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>List Books</title>
    </head>
    <body>
        <h1>List of Books</h1>
        
            <ul>

                <c:forEach var="book" items="${listAllBooks}" varStatus="num">
                    <li>
                        <c:if test="${book.active eq true}"> Active </c:if>
                        <c:if test="${book.active ne true}"> Disable </c:if>
                        <a href="changeActiveBooks?bookId=${book.id}&active=${book.active}"> Change status </a>
                        ${num.index}.${book.title}. Author: ${book.author}. Year: ${book.year}.
                    </li>
                </c:forEach>
            </ul>
            
            <a href="index.jsp"> back </a>
       
    </body>
</html>
