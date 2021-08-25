package crud.service;

import crud.model.User;

import java.util.List;

public interface UserService {

    User getById(Long id);
    List<User> getAllUsers();
    List<User> getByName(String firstName, String lastName);
    User getByEmail(String email);
    User getByPhone(String phone);
    void save(User user);
    void removeUser(Long id);
    void updateUser(long id, User user);
}
