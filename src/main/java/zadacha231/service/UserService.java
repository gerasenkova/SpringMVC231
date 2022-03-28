package zadacha231.service;

import zadacha231.model.User;

import java.util.List;

public interface UserService {
    List<User> userList();
    Object add(User user);
    Object update(User user);
    void delete(User user);
    User getById(int id);
}
