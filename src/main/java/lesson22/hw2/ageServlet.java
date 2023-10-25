package lesson22.hw2;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Objects;

@WebServlet(urlPatterns = "/age")
public class ageServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer age = Integer.valueOf(req.getParameter("age"));
        String securityAnswer = (age >= 18) ? "es 18!" : "No 18!";
        resp.getWriter().println("age , %s!".formatted(Objects.toString(securityAnswer, "NO Age")));
    }
}
