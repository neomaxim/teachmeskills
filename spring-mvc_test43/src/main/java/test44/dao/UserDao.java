package test44.dao;

import test44.entity.User;

import java.util.Optional;

public interface UserDao {

    void save(User user);

    void remove(User user);

    Optional<User> findById(Long id);


}