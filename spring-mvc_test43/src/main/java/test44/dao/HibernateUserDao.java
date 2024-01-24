package test44.dao;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import org.springframework.stereotype.Repository;
import test44.entity.User;

import javax.transaction.Transactional;
import java.util.Optional;


    @Log4j
    @Repository
  //  @Transactional(readOnly = true)//(noRollbackFor = RuntimeException.class)
    @Transactional()
    @RequiredArgsConstructor
    public class HibernateUserDao implements UserDao {

        private final SessionFactory sessionFactory;
       // private final PhoneDao phoneDao;

        @Override

        public void save(User user) {
            Session currentSession = sessionFactory.getCurrentSession();
          currentSession.save(user);

        }

        @Override

        public void remove(User user) {
       Session currentSession = sessionFactory.getCurrentSession();
//       currentSession.remove(user);
        user.setDeletable(true);
            currentSession.save(user);
//        currentSession.update(user);
          //  Session currentSession = sessionFactory.getCurrentSession();
          //  currentSession.remove(user);
        }

        @Override
        public Optional<User> findById(Long id) {
            Session currentSession = sessionFactory.getCurrentSession();
          //  Optional<User> user = Optional.ofNullable(currentSession.get(User.class, id));
            return Optional.ofNullable(currentSession.get(User.class,id));
        }




}
