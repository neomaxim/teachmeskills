package lesson34.loger;

import lesson34.Dispatcher;
import org.apache.log4j.Logger;


import java.util.Random;

public class UserService {
    private static final Logger LOGGER = Logger.getLogger(UserService.class);

    public void save(Dispatcher dispatcher) {
        LOGGER.info("try to save USER" + dispatcher.toString());
        if (new Random().nextBoolean()) {
            LOGGER.warn("pay attention to user" + dispatcher);
        } else {
            LOGGER.error("error happens during user saving " + dispatcher);
        }
    }

}
