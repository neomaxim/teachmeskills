package lesson32;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/frontController")
public class FrontControllerServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");

        String username=request.getParameter("username");
        String password=request.getParameter("pwd2");

       if (password.equals("aA12345678")&& username.equals("Maxim")) {


            RequestDispatcher rd=request.getRequestDispatcher("WEB-INF/success.jsp");
            rd.forward(request, response);
        } else {

            RequestDispatcher rd=request.getRequestDispatcher("WEB-INF/errorLoginAndPasword.jsp");
            rd.forward(request, response);
        }

    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        req.getRequestDispatcher("WEB-INF/loginAndPasword.jsp").forward(req, resp);
    }

}
