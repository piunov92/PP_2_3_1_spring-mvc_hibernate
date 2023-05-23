package web.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import web.models.User;

import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {

    private final SessionFactory sessionFactory;

    @Autowired
    public UserDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public List<User> getUsers() {
        return sessionFactory.getCurrentSession().createQuery("from User", User.class).getResultList();
    }

    @Override
    public void saveUser(User user) {
            sessionFactory.getCurrentSession().saveOrUpdate(user);
    }

    @Override
    public User getUserById(int id) {
        return sessionFactory.getCurrentSession().get(User.class, id);
    }

    @Override
    public void deleteUser(int id) {
        sessionFactory.getCurrentSession()
                .createQuery("delete from User where id = :userId")
                .setParameter("userId", id)
                .executeUpdate();
    }
}
