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
            
            First Name: <input type="text" name="name" value="${name}"><br>
            Last name: <input type="text" name="lastname" value="${lastname}"><br>
            Day: <input type="text" name="day" value="${day}"><br>
            Month: <input type="text" name="month" value="${month}"><br>
            Year: <input type="text" name="year" value="${year}"><br>
            
            <p>Registration: </p>
            Login <input type="text" name="login" value="${login}"><br>
            Password: <input type="password" name="password1" value=""><br>
            Confirmed password: <input type="password" name="password2" value=""><br>
            <input type="submit" value="New Reader"><br>
            <a href="index.jsp">Back </a><br>
        </form>
    </body>
</html>
