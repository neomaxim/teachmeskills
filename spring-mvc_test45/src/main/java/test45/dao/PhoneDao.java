package test45.dao;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import test45.entity.Phone;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Repository
@RequiredArgsConstructor
public class PhoneDao {

    //    private final SessionFactory sessionFactory;
    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public Phone save(Phone phone) {
//        Session currentSession = sessionFactory.getCurrentSession();
        if (phone.getId() == null) {
            entityManager.persist(phone);
        } else {
            entityManager.merge(phone);
        }
        return phone;
    }

}