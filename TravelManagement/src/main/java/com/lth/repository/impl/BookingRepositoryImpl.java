package com.lth.repository.impl;

import com.lth.pojos.Booking;
import com.lth.repository.BookingRepository;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.Query;
import java.util.List;

@Repository
@Transactional
public class BookingRepositoryImpl implements BookingRepository {
    @Autowired
    private LocalSessionFactoryBean sessionFactory;

    @Override
    public boolean addBooking(Booking booking) {
        Session session = sessionFactory.getObject().getCurrentSession();
        try {
            session.save(booking);
            return true;
        } catch (HibernateException ex) {
            System.err.println(ex.getMessage());
        }
        return false;
    }

    @Override
    public List<Integer> getYear() {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        Query query = session.createQuery( "SELECT DISTINCT YEAR(b.createdDate) AS year "
                + "FROM Booking b "
                + "GROUP BY year "
                + "ORDER BY year ASC");
        return query.getResultList();
    }
}
