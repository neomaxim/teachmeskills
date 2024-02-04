package test45.dao;

import lombok.RequiredArgsConstructor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import test45.entity.Phone;

import javax.transaction.Transactional;


    @Repository
    @RequiredArgsConstructor
    public class PhoneDao {

        private final SessionFactory sessionFactory;

        @Transactional
        public Phone save(Phone phone) {
            Session currentSession = sessionFactory.getCurrentSession();
            if (phone.getId() == null) {
                currentSession.save(phone);
            } else {
                currentSession.update(phone);
            }
            return phone;
        }


}
