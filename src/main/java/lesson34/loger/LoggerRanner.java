package lesson34.loger;

import org.apache.log4j.Logger;
import temp.pattern.frontController.Dispatcher;

public class LoggerRanner {
    private  static  final Logger LOGGER = Logger.getLogger(LoggerRanner.class);
    private static final UserService userService = new UserService();
    public static void main(String[] args) {
        Dispatcher dispatcher =new Dispatcher();
        dispatcher.setHomeView(dispatcher.getHomeView());
        dispatcher.setStudentView(dispatcher.getStudentView());
        LOGGER.info(dispatcher);
        userService.save(dispatcher);

    }
}
