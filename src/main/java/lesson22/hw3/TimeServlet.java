package lesson22.hw3;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalTime;

@WebServlet(urlPatterns = {"/minsk","/washington","/beijing"})
public class TimeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

      LocalTime result = switch (req.getServletPath()){
            case "/minsk" ->getTime(0);
            case "/washington" ->getTime(-4);
            case "/beijing" ->getTime(+8);
            default -> LocalTime.now();
        };
      resp.getWriter().println(result);
    }
    public static LocalTime getTime(Integer timeZone){
        LocalTime nowTime = LocalTime.now();
      return nowTime.plusHours(timeZone);
    }

}
