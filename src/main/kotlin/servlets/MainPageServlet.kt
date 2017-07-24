package servlets

import util.UserManager
import javax.servlet.http.Cookie
import javax.servlet.http.HttpServlet
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

class MainPageServlet : HttpServlet() {

    override fun doPost(req: HttpServletRequest, resp: HttpServletResponse) {
        val login = req.getParameter("login")?.trim().orEmpty().toLowerCase()
        val password = req.getParameter("password")?.trim().orEmpty()

        when (UserManager.login(login, password)) {
            0 -> {
                resp.sendRedirect("/offers")
                val cookie = Cookie("login", login)
                resp.addCookie(cookie)
                return
            }
            -1 -> req.setAttribute("System_message", "Wrong password, try again")
            1 -> req.setAttribute("System_message", "New user added")
        }

        req.getRequestDispatcher("index.jsp").forward(req, resp)
    }

    override fun doGet(req: HttpServletRequest, resp: HttpServletResponse) {
        //req.setAttribute("hidden_profile", "hidden")
        //req.setAttribute("hidden_login_form", "hidden")
        req.getRequestDispatcher("index.jsp").forward(req, resp)
    }
}