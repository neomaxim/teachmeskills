package auto.dao;


import auto.model.Auto;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public class AutoDAOImpl implements AutoDAO {
    private SessionFactory sessionFactory;

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Auto> allAutos(int page) {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("from Auto").setFirstResult(10 * (page - 1)).setMaxResults(10).list();
    }

    @Override
    public void add(Auto auto) {
        Session session = sessionFactory.getCurrentSession();
        session.persist(auto);
    }

    @Override
    public void delete(Auto auto) {
        Session session = sessionFactory.getCurrentSession();
        session.delete(auto);
    }

    @Override
    public void edit(Auto auto) {
        Session session = sessionFactory.getCurrentSession();
        session.update(auto);
    }

    @Override
    public Auto getById(int id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(Auto.class, id);
    }

    @Override
    public int autosCount() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("select count(*) from Auto", Number.class).getSingleResult().intValue();
    }

    @Override
    public boolean checkVin(String vin) {
        Session session = sessionFactory.getCurrentSession();
        Query query;
        query = session.createQuery("from Auto where vin = :vin");
        query.setParameter("vin", vin);
        return query.list().isEmpty();
    }
}