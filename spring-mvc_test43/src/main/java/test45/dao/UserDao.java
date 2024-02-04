package test45.dao;

import test45.entity.User;

import java.util.Optional;

public interface UserDao {

    void save(User user);

    void remove(User user);

    Optional<User> findById(Long id);


}