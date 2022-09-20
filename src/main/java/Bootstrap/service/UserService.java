package Bootstrap.service;

import Bootstrap.model.Users;

import java.util.List;

public interface UserService {
    void saveUser(Users user);

    void updateUser(Users user);

    void deleteUser(long id);

    List<Users> getAllUsers();

    Users getUserByLogin(String login);

    Users getUserById(long id);
}