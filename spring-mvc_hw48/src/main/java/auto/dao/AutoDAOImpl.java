package auto.dao;

import auto.model.Auto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import java.util.List;

@RequiredArgsConstructor
@Repository
public class AutoDAOImpl implements AutoDAO {

    @PersistenceContext
    private EntityManager entityManager;


    @Override
    public List<Auto> getAllAuto() {
        return entityManager.createQuery("from Auto", Auto.class).getResultList();
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
    public Auto getById(int id) {

        return entityManager.getReference(Auto.class, id);
    }

    @Override

    public void edit(Auto auto) {

        entityManager.merge(auto);
    }

    @Override
    public boolean checkVin(String vin) {

        Query query;
        query = entityManager.createQuery("from Auto where vin = :vin");
        query.setParameter("vin", vin);
        return query.getResultList().isEmpty();

    }
}