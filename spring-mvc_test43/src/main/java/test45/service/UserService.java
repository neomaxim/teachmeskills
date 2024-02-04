package test45.service;

import test45.dto.UserDto;

import java.util.Optional;

public interface UserService {
    String name();

    String generateName(Long id);

    void registration(String login, String password, String email, Integer age);

    void create(UserDto userDto);
    void update(UserDto userDto);
    void remove(Long id);
    Optional<UserDto> finById(Long id);
}
