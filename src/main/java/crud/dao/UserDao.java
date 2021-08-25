package crud.dao;

import crud.model.User;

import java.util.List;

public interface UserDao {

    List<User> getAllUsers();
    List<User> getByName(String firstName, String lastName);
    User getById(Long id);
    User getByEmail(String email);
    User getByPhone(String phone);
    void save(User user);
    void removeUser(Long id);
    void updateUser(Long id, User user);
}
