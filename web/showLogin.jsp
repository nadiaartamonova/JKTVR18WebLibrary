<%-- 
    Document   : showLogin
    Created on : 14-Oct-2019, 15:12:27
    Author     : pupil
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Sing In</title>
    </head>
    <body>
        
        <h1>Sing In</h1>
        <p>${info}</p>
        <form action="login" method="POST">
            login <input type="test" name="login"> <br>
            password <input type="password" name="password"> <br>
            
            <input type="submit" name="SingIn">
        </form>
    </body>
</html>
