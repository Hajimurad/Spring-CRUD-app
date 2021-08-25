package crud.dao;

import crud.model.User;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class UserDaoImpl implements UserDao{



    @PersistenceContext
    EntityManager entityManager;

    @Override
    public User getById(Long id) {
        return entityManager.find(User.class, id);
    }

    @Override
    public List<User> getAllUsers() {
        return entityManager.createQuery("FROM User", User.class).getResultList();
    }

    @Override
    public List<User> getByName(String firstName, String lastName) {
        return entityManager.createQuery(
                        "SELECT u FROM User u WHERE u.firstName LIKE :firstname AND u.lastName LIKE :lastname", User.class)
                .setParameter("FIRST_NAME", firstName)
                .setParameter("LAST_NAME", lastName)
                .getResultList();
    }

    @Override
    public User getByEmail(String email) {
        return  entityManager.createQuery(
                        "SELECT u FROM User u WHERE u.email LIKE :email", User.class)
                .setParameter("EMAIL", email)
                .getSingleResult();
    }

    @Override
    public User getByPhone(String phone) {
        return entityManager.createQuery(
                        "SELECT u FROM User u WHERE u.phone LIKE :phone", User.class)
                .setParameter("PHONE", phone)
                .getSingleResult();
    }

    @Override
    public void save(User user) {
        entityManager.merge(user);
    }

    @Override
    public void updateUser(Long id, User user) {
        entityManager.merge(user);
    }

    @Override
    public void removeUser(Long id) {
        entityManager.createQuery("DELETE FROM User u WHERE u.id=:id")
                .setParameter("id", id)
                .executeUpdate();
    }
}
