package servlets

import db.PSQL
import helpers.md5
import javax.servlet.http.HttpServlet
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

class Servlet : HttpServlet() {
    override fun doPost(req: HttpServletRequest, resp: HttpServletResponse) {
        val login = req.getParameter("login")?.trim().orEmpty()
        val password = req.getParameter("password")?.trim().orEmpty()

        if (!PSQL.isConnected) PSQL.connect()
        val user = PSQL.doSelect("SELECT * FROM users WHERE login='$login';")
        if (user!!.next()) {
            if (md5(password) == user.getString("password")) {
                req.setAttribute("System_message", "Successful")
                resp.sendRedirect("/chat")
                return
            } else {
                req.setAttribute("System_message", "Wrong password, try again")
            }
        } else {
            PSQL.doInsert(
                "INSERT INTO users (login, password) VALUES ('$login', '${md5(password)}');"
            )
            req.setAttribute("System_message", "New user added")
        }
        req.getRequestDispatcher("index.jsp").forward(req, resp)
    }

    override fun doGet(req: HttpServletRequest, resp: HttpServletResponse) {
        req.setAttribute("Title", "Sign In")
        req.getRequestDispatcher("index.jsp").forward(req, resp)
    }
}