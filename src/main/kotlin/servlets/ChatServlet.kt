package servlets

import javax.servlet.http.HttpServlet
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

class ChatServlet: HttpServlet() {
    override fun doGet(req: HttpServletRequest, resp: HttpServletResponse) {
        req.getRequestDispatcher("chat.jsp").forward(req, resp)
    }
}