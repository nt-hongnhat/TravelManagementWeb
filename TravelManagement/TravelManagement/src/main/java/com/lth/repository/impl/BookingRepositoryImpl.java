package com.lth.repository.impl;

import com.lth.pojos.Booking;
import com.lth.repository.BookingRepository;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class BookingRepositoryImpl implements BookingRepository {
    @Autowired
    private LocalSessionFactoryBean sessionFactoryBean;

    @Override
    public boolean addBooking(Booking booking) {
        Session session = sessionFactoryBean.getObject().getCurrentSession();
        try {
            session.save(booking);
            return true;
        } catch (HibernateException ex) {
            System.err.println(ex.getMessage());
        }
        return false;
    }
}
