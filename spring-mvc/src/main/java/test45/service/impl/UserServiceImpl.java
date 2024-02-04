package test45.service.impl;

import lombok.extern.log4j.Log4j;
import org.springframework.stereotype.Service;
import test45.exception.CustomException;
import test45.service.UserService;

@Log4j
@Service // @Component
public class UserServiceImpl implements UserService {

    @Override
    public String name() {
        return "User!";
    }

    @Override
    public String generateName(Long id) {
        return "User" + id;
    }

    @Override
    public void registration(String login, String password, String email, Integer age) {
        log.info("login => %s, password => ***, email => %s, age => %d".formatted(login, email, age));
        if (age > 55) {
            throw new CustomException("User is not matched for our requirements");
        }
    }
}
