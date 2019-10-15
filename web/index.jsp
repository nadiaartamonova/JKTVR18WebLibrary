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
                  
            <h2>Actions : </h2>
            <a href="newBook">1. New book</a><br>
            <a href="newReader">2. New reader</a><br>
            <a href="takeOn">3. Took book</a><br>
            <a href="returnBook">4. Book return</a><br>
            <a href="showListAllBooks">5. Show list all books</a><br>
        </div>
    </body>
</html>
