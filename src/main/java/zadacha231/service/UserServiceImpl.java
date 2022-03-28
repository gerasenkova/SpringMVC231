package zadacha231.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import zadacha231.dao.UserDao;
import zadacha231.model.User;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{
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
    public Object add(User user) {
        userDao.add(user);
        return null;
    }

    @Override
    @Transactional
    public void delete(User user) {
        userDao.delete(user);
    }

    @Override
    @Transactional
    public Object update(User user) {
        userDao.update(user);
        return null;
    }

    @Override
    @Transactional
    public User getById(int id) {
        return userDao.getById(id);
    }
}
