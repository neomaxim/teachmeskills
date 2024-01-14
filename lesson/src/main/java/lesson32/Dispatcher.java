package lesson32;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class Dispatcher {
    public static final Logger LOGGER = LogManager.getLogger(Dispatcher.class.getName());

    public void dispatch(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       // LOGGER.info("method started");
        response.setContentType("text/html;charset=UTF-8");
        String username = request.getParameter("username");
        String password = request.getParameter("pwd2");
        if (password == null || username == null) {
            request.getRequestDispatcher("WEB-INF/loginAndPasword.jsp").forward(request, response);
        }
        IsAuthenticatorUser date = new IsAuthenticatorUser(username, password);

        if (date.isAuthenticUser(username, password)) {

            request.getRequestDispatcher("WEB-INF/success.jsp").forward(request, response);
        } else {
            request.getRequestDispatcher("WEB-INF/errorLoginAndPasword.jsp").forward(request, response);
        }
    }
}
