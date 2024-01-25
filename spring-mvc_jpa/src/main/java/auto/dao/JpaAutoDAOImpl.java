package auto.dao;

import auto.model.Auto;


import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;


@Repository
//@RequiredArgsConstructor
public class JpaAutoDAOImpl implements AutoDAO {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Auto> allAutos(int page) {

        return entityManager.createQuery("from Auto").setFirstResult(10 * (page - 1)).setMaxResults(10).getResultList();

    }

    @Override
    public void add(Auto auto) {

        entityManager.persist(auto);
    }

    @Override
    public void delete(Auto auto) {

        entityManager.remove(auto);
    }

    @Override

    public void edit(Auto auto) {

        entityManager.merge(auto);
    }

    @Override
    public Auto getById(int id) {

        return entityManager.getReference(Auto.class, id);
    }

    @Override
    public int autosCount() {

        return entityManager.createQuery("select count (*) from Auto", Number.class).getSingleResult().intValue();
    }

    @Override
    public boolean checkVin(String vin) {

        Query query;
        query = entityManager.createQuery("from Auto where vin = :vin");
        query.setParameter("vin", vin);
        return query.getResultList().isEmpty();

    }
}