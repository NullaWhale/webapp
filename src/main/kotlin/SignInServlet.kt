import java.io.PrintWriter
import javax.jws.WebService
import javax.servlet.annotation.WebServlet
import javax.servlet.http.HttpServlet
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

@WebServlet(name = "SignIn", value = "/signIn")
class SignInServlet : HttpServlet() {

    override fun doGet(req: HttpServletRequest, resp: HttpServletResponse) {
        resp.writer.write(
            "Hello, ${req.getParameter("login")}. \n" +
            "Your password is ${req.getParameter("password")}"
        )
    }
}