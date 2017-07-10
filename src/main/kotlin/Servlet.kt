import db.PSQL
import javax.servlet.annotation.WebServlet
import javax.servlet.http.HttpServlet
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

@WebServlet(name = "Hello", value = "/hello")
class Servlet : HttpServlet() {

    override fun doPost(req: HttpServletRequest, resp: HttpServletResponse) {

        val login = req.getParameter("login")?.trim().orEmpty()
        val password = req.getParameter("password")?.trim().orEmpty()

        if (!PSQL.isConnected) PSQL.connect()
        val user = PSQL.doSelect(
            "SELECT * FROM users WHERE login='$login' and password='$password';"
        )
        if (!user!!.next()) {
            PSQL.doInsert(
                "INSERT INTO users (login, password) VALUES ('$login', '$password');"
            )
            req.setAttribute("System_message", "New user added")
        } else if (user.next() && password != user.getString("password")) {
            req.setAttribute("System_message", "Password wrong")
        } else {
            req.setAttribute("System_message", "Successful")
        }
        req.getRequestDispatcher("index.jsp").forward(req, resp)
    }

    override fun doGet(req: HttpServletRequest, resp: HttpServletResponse) {
        req.setAttribute("Title", "Sign In")
        req.getRequestDispatcher("index.jsp").forward(req, resp)
    }
}