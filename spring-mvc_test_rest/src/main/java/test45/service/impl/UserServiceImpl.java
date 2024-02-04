package test45.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;
import org.springframework.stereotype.Service;
import test45.dto.UserDto;

import test45.repository.UserRepository;
import test45.service.UserService;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public List<UserDto> getAll() {
        return userRepository.getAll();
    }

    @Override
    public UserDto create(UserDto userDto) {
        return userRepository.create(userDto);
    }

    @Override
    public void update(Long id, UserDto response) {
        userRepository.update(id, response);
    }

    @Override
    public void deleteById(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public Optional<UserDto> getById(Long id) {
        return userRepository.getById(id);
    }
}