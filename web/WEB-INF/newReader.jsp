<%-- 
    Document   : newReader
    Created on : Oct 2, 2019, 9:08:30 AM
    Author     : pupil
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Reader</title>
    </head>
    <body>
        <h1>Reader</h1>
        <p>${info}</p>
        <form action="addReader" method="POST">
            <a href="index.html">Back </a><br>
            First Name: <input type="text" name="name" value="${reader.name}"><br>
            Last name: <input type="text" name="lastname" value="${reader.lastname}"><br>
            Day: <input type="text" name="day" value="${reader.day}"><br>
            Month: <input type="text" name="month" value="${reader.month}"><br>
            Year: <input type="text" name="year" value="${reader.year}"><br>
            <input type="submit" value="Reader was added"><br>
            
        </form>
    </body>
</html>
