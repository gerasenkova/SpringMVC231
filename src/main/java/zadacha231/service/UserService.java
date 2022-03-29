package zadacha231.service;

import zadacha231.model.User;

import java.util.List;

public interface UserService {
    List<User> userList();
    void saveUser(User user);
    void updateUser(int id, User updateUser);
    void delete(User user);
    User getById(int id);
}
