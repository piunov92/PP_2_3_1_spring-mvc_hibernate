package web.dao;

import org.springframework.stereotype.Repository;
import web.models.User;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {

    @PersistenceContext(unitName = "entityManagerFactory")
    private EntityManager entityManager;
    
    @Override
    public List<User> getUsers() {
        return entityManager.createQuery("from User", User.class).getResultList();
    }

    @Override
    public void saveUser(User user) {
        User existingUser = getUserById(user.getId());
        if(existingUser == null) {
            entityManager.persist(user);
        } else {
            existingUser.setName(user.getName());
            existingUser.setSurname(user.getSurname());
            existingUser.setAge(user.getAge());
        }
    }

    @Override
    public User getUserById(int id) {
        return entityManager.find(User.class, id);
    }

    @Override
    public void deleteUser(int id) {
        entityManager.remove(getUserById(id));
        entityManager.flush();
    }
}
