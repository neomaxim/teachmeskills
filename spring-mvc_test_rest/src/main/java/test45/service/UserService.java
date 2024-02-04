package test45.service;

import test45.dto.UserDto;

import java.util.List;
import java.util.Optional;

public interface UserService {
    List<UserDto> getAll();

    UserDto create(UserDto userDto);

    void update(Long id, UserDto response);

    void deleteById(Long id);

    Optional<UserDto> getById(Long id);
}