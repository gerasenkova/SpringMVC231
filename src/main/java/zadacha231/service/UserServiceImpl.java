package zadacha231.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import zadacha231.dao.UserDao;
import zadacha231.model.User;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    final
    UserDao userDao;

    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    @Transactional
    public List<User> userList() {
        return userDao.userList();
    }

    @Override
    @Transactional
    public void saveUser(User user) {
        userDao.saveUser(user);
    }

    @Override
    @Transactional
    public void delete(User user) {
        userDao.delete(user);
    }

    @Override
    @Transactional
    public void updateUser(int id, User user){
        userDao.updateUser(id, user);
    }

    @Override
    @Transactional
    public User getById(int id) {
        return userDao.getById(id);
    }
}
