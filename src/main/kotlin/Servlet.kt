import javax.jws.WebService
import javax.servlet.annotation.WebServlet
import javax.servlet.http.HttpServlet
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

@WebServlet(name = "Hello", value = "/hello")
class Servlet : HttpServlet() {
    override fun doGet(req: HttpServletRequest, resp: HttpServletResponse) {
//        resp.writer.write("Hello, World")
        req.setAttribute("Title", "Sign In")
        req.getRequestDispatcher("index.jsp").forward(req, resp)
    }
}