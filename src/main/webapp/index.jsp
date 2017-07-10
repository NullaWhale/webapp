<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
    <head>
        <title>${Title}</title>
    </head>

    <body>
        <form action="/test" method="POST">
            Login: <input type="text" name="login" title=""><br>
            Password: <input type="password" name="password" title=""><br>
            <input type="submit" name="submit" value="Enter chat">
        </form>
    </body>
</html>