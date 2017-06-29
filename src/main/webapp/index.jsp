<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String login = request.getParameter("login");
    String password = request.getParameter("password");

%>
<html>
    <head>
        <title>${Title}</title>
    </head>

    <body>
        <form action="" method="GET">
            Login: <input type="text" name="login" value="<%= login %>"><br>
            Password: <input type="text" name="password" value="<%= password %>"><br>
            <input type="submit" name="submit">
        </form>
    </body>
</html>