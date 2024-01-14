package lesson24;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/verse")
public class Verse extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        if (request.getParameter("username") == null ||
                request.getParameter("username").isEmpty() ||
                request.getParameter("username").matches("\\d+") ||
                !request.getParameter("userage").matches("\\d+") ||
                request.getParameter("country").isEmpty()) {
            request.getRequestDispatcher("WEB-INF/first-layout.jsp").forward(request, response);
        } else
            request.getRequestDispatcher("WEB-INF/save-ok.jsp").forward(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        req.getRequestDispatcher("WEB-INF/first-layout.jsp").forward(req, resp);
    }
}