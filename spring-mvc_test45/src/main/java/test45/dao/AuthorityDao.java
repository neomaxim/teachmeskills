package test45.dao;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import test45.entity.Authority;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Repository
@RequiredArgsConstructor
public class AuthorityDao {

//    private final SessionFactory sessionFactory;

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public Authority save(Authority authority) {
//        Session currentSession = sessionFactory.getCurrentSession();
        if (authority.getId() == null) {
            entityManager.persist(authority);
        } else {
            entityManager.merge(authority);
        }
        return authority;
    }
}
