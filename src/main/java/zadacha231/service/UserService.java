package zadacha231.service;

import zadacha231.model.User;

import java.util.List;

public interface UserService {
    List<User> userList();
    void saveUser(User user);
    void updateUser(User updateUser);
    void delete(int id);
    User getById(int id);
}
