package zadacha231.dao;

import zadacha231.model.User;

import java.util.List;

public interface UserDao {
    List<User> userList();
    void saveUser(User user);
    void updateUser(int id, User updateUser);
    void delete(User user);
    User getById(int id);
}
