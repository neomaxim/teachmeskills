package lesson26.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/formInfo")
public class FormInfo extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        if (request.getParameter("username") == null ||
                request.getParameter("username").isEmpty() ||
                request.getParameter("username").matches("\\d+") ||
                !request.getParameter("userage").matches("\\d+") ||
                request.getParameter("country").isEmpty()) {
            request.getRequestDispatcher("WEB-INF/save-request.jsp").forward(request, response);
        } else
            request.getRequestDispatcher("WEB-INF/save-ok.jsp").forward(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        req.getRequestDispatcher("WEB-INF/save-request.jsp").forward(req, resp);
    }
}
