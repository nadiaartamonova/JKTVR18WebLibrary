<%-- 
    Document   : index
    Created on : 14-Oct-2019, 13:32:02
    Author     : pupil
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Nadia library</title>
    </head>
    <body>
        <h1>Nadia library</h1>
        
        <div>
             <p>${info}</p>
            <c:if test="${user == null}">
                <a href="showLogin"> Sing In</a> 
            </c:if>
            
            <c:if test="${user != null}">
                <a href="logout"> Logout</a><br>
            </c:if>
                  
            <h2>Actions: </h2>
            <h4>For guest: </h4>
            
            <a href="showListAllBooks">Show list all books</a><br>
            <a href="newReader">Register new reader</a><br>
            
            <c:if test="${null!=user}">
                <h4> For registered users: </h4>
                <a href="takeOn">Buy book</a><br>

            </c:if>
            
            
            <c:if test="${null!=user  && 'nadia' eq user.login}">
                <h4> For manager: </h4>
                <a href="newBook">1. New book</a><br>
                <a href="takeOn">2. Took book</a><br>
                <a href="returnBook">3. Book return</a><br>
            </c:if>
        </div>
    </body>
</html>
