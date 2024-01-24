package test44.service.impl;

import lombok.Data;
import lombok.extern.log4j.Log4j;
import org.springframework.stereotype.Service;
import test44.dao.UserDao;
import test44.dto.UserDto;
import test44.entity.User;
import test44.exception.CustomException;
import test44.service.UserService;

import java.util.Optional;

@Log4j
@Service // @Component
@Data
public class UserServiceImpl implements UserService {
private  final UserDao userDao;
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



    @Override
    public void create(UserDto userDto) {
userDao.save(new User(userDto));
    }

    @Override
    public void update(UserDto userDto) {


    }

    @Override
    public void remove(Long id) {

    }

    @Override
    public Optional<UserDto> finById(Long id) {
        return Optional.empty();
    }


}
