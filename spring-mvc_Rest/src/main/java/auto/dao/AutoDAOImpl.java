package auto.dao;


import auto.model.Auto;
import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@RequiredArgsConstructor
@Repository
public class AutoDAOImpl implements AutoDAO {

    @PersistenceContext
    private EntityManager entityManager;

 /*   @Override
    public Optional<Auto> getCarById(Long id) {
        return Optional.ofNullable(entityManager.find(Auto.class, id));
    }
*/
  @Override
    public Auto saveAuto(Auto auto) {
        entityManager.persist(auto);
        return auto;
    }

    @Override
    public void add(Auto auto) {

        entityManager.persist(auto);
    }
    @Override
    public Auto getById(int id) {

        return entityManager.getReference(Auto.class, id);
    }




    @Override
    public List<Auto> getAllAuto() {
        return entityManager.createQuery("from Auto",Auto.class).getResultList();
    }





    @Override
    public void delete(Auto auto) {

        entityManager.remove(auto);
    }



    @Override

    public void edit(Auto auto) {

        entityManager.merge(auto);
    }
}