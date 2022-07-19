package com.lth.repository.impl;

import com.lth.pojos.*;
import com.lth.repository.StatsRepository;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;

@Repository
@Transactional
public class StatsRepositoryImpl implements StatsRepository {
    @Autowired
    private LocalSessionFactoryBean sessionFactory;

    @Override
    public List<Object[]> numberOfToursStatsByMonth(int year) {
        Session session = sessionFactory.getObject().getCurrentSession();
        Query query = session.createQuery( "SELECT MONTH(td.departure) AS month, count(*) AS number_of_tour "
                                            + "FROM Tour t, TourDeparture td "
                                            + "WHERE t.id = td.tour.id AND YEAR(td.departure) = :year "
                                            + "GROUP BY month "
                                            + "ORDER BY month ASC");
        query.setParameter("year", year);
        return query.getResultList();
    }

    @Override
    public List<Object[]> numberOfToursStatsByYear() {
        Session session = sessionFactory.getObject().getCurrentSession();
        Query query = session.createQuery( "SELECT YEAR(td.departure) AS year, count(*) AS number_of_tour "
                + "FROM Tour t, TourDeparture td "
                + "WHERE t.id = td.tour.id "
                + "GROUP BY year "
                + "ORDER BY year ASC");
        return query.getResultList();
    }

    @Override
    public List<Object[]> revenueByMonth(int year) {
        Session session = sessionFactory.getObject().getCurrentSession();
        Query query = session.createQuery( "SELECT MONTH(b.createdDate) AS month, sum(bd.totalPrice) AS revenue "
                + "FROM Booking b, BookingDetail bd "
                + "WHERE b.bookingDetail.id = bd.id AND YEAR(b.createdDate) = :year "
                + "GROUP BY month "
                + "ORDER BY month ASC");
        query.setParameter("year", year);
        return query.getResultList();
    }

    @Override
    public List<Object[]> revenueByYear() {
        Session session = sessionFactory.getObject().getCurrentSession();
        Query query = session.createQuery( "SELECT YEAR(b.createdDate) AS year, sum(bd.totalPrice) AS revenue "
                + "FROM Booking b, BookingDetail bd "
                + "WHERE b.bookingDetail.id = bd.id "
                + "GROUP BY year "
                + "ORDER BY year ASC");
        return query.getResultList();
    }
}
