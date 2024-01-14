package test39.service;

public interface UserService {
    String name();

    String generateName(Long id);

    void registration(String login, String password, String email, Integer age);
}
