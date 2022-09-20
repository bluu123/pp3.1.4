package Bootstrap.dao;

import Bootstrap.model.Users;
import org.springframework.stereotype.Repository;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void saveUser(Users user) {
        entityManager.persist(user);
    }

    @Override
    public void updateUser(Users user) {
        entityManager.merge(user);
    }

    @Override
    public void deleteUser(long id) {
        Users someUser = entityManager.find(Users.class, id);
        entityManager.remove(someUser);
    }

    @Override
    public List<Users> getAllUsers() {
        return entityManager.createQuery("select u from Users u", Users.class).getResultList();
    }

    @Override
    public Users getUserByLogin(String login) {
        return entityManager.createQuery("select u from Users u where u.login =: login", Users.class)
                .setParameter("login", login).getSingleResult();
    }

    @Override
    public Users getUserById(long id) {
        return entityManager.find(Users.class, id);
    }
}