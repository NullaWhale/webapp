<%@ page import="util.UserManager" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
    <head>
        <title>Offers</title>
        <link rel="stylesheet" href="bootstrap/css/bootstrap.css"/>
    </head>

    <body>
        <nav class="navbar navbar-toggleable-md navbar-inverse fixed-top bg-inverse">
            <div class="collapse navbar-collapse" id="navbarsExampleDefault">
                <ul class="navbar-nav mr-auto">
                    <li class="nav-item active">
                        <a class="nav-link" href="#">Home <span class="sr-only">(current)</span></a>
                    </li>
                </ul>
                <div ${hidden_login_form}>
                    <form class="form-inline my-2 my-lg-0" id="enterOffers" action="/offers" method="POST">
                        <input class="form-control mr-sm-2" type="text" name="login" title="" placeholder="Login">
                        <input class="form-control mr-sm-2" type="password" name="password" title="" placeholder="Password">
                        <button class="btn btn-outline-success my-2 my-sm-0" type="submit" name="submit">Log In</button>
                    </form>
                </div>
                <div ${hidden_profile}> Hi, ${currentUser} </div>
            </div>
        </nav>
        <%--<h1 align="center">Здарова, ${currentUsername}</h1>
        <aside>
            <h5>Online User(s)</h5>
            <ul id="userList"></ul>
        </aside>
        <article>
            <div id="dialog">
                <span>Chat to All</span>
                <div id="message-board"></div>
                <hr>
                <textarea id="message" placeholder="message.."></textarea>
                <button id="send">Send</button>
            </div>
        </article>--%>

        <script src="jquery-3.2.1.js"></script>
        <script src="bootstrap/js/bootstrap.js"></script>
        <script src="js/script.js"></script>
    </body>
</html>
