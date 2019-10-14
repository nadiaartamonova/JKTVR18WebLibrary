<%-- 
    Document   : page1
    Created on : Sep 27, 2019, 10:59:53 AM
    Author     : Melnikov
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Book</title>
    </head>
    <body>
        <h1>Book</h1>
        <p>${info}</p>
        <form action="addBook" method="POST">
            
            Title of book: <input type="text" name="title" value="${book.title}"><br>
            Author of book: <input type="text" name="author" value="${book.author}"><br>
            Year of publish: <input type="text" name="year" value="${book.year}"><br>
            Books quantity: <input type="text" name="quantity" value="${book.quantity}"><br>
            <input type="submit" value="Book was added"> <br>
            <a href="index.jsp">Back </a><br>
        </form>
    </body>
</html>
