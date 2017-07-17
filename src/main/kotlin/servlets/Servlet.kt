package servlets

import helpers.DAO.UserDAO
import helpers.DAO.UserDAOImpl
import helpers.md5
import models.User
import javax.servlet.http.HttpServlet
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

class Servlet : HttpServlet() {

    override fun doPost(req: HttpServletRequest, resp: HttpServletResponse) {
        val login = req.getParameter("login")?.trim().orEmpty()
        val password = req.getParameter("password")?.trim().orEmpty()

        val userDAO: UserDAO = UserDAOImpl()

        val user: User? = userDAO.getUserByName(login)
        if (user != null) {
            if (md5(password) == user.password) {
                req.setAttribute("System_message", "Successful")
                resp.sendRedirect("/chat")
                return
            } else {
                req.setAttribute("System_message", "Wrong password, try again")
            }
        } else {
            userDAO.createUser(login, md5(password))
            req.setAttribute("System_message", "New user added")
        }
        req.getRequestDispatcher("index.jsp").forward(req, resp)
    }

    override fun doGet(req: HttpServletRequest, resp: HttpServletResponse) {
        req.setAttribute("Title", "Sign In")
        req.getRequestDispatcher("index.jsp").forward(req, resp)
    }
}