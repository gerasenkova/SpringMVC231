package zadacha231.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import zadacha231.model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<User> userList() {
        TypedQuery<User> query = entityManager.createQuery("select u from User u", User.class);
        return query.getResultList();
    }

    @Override
    public void saveUser(User user) {
        entityManager.persist(user);
    }

    @Override
    public void updateUser(int id, User newUser) {
        User oldUser = entityManager.find(User.class, newUser.getId());
        oldUser.setName(newUser.getName());
        oldUser.setEmail(newUser.getEmail());
        oldUser.setAge(newUser.getAge());
    }

    @Override
    public void delete(User user) {
        entityManager.remove(user);
    }

    @Override
    public User getById(int id) {
        String jpql = "select u from User u where u.id=:id";
        TypedQuery<User> query = entityManager.createQuery(jpql, User.class).setParameter("id", id);
        return query.getSingleResult();
    }
}
