package zadacha231.dao;

import zadacha231.model.User;

import java.util.List;

public interface UserDao {
    List<User> userList();
    void add(User user);
    void update(User user);
    void delete(User user);
    User getById(int id);
}
