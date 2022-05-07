package com.lth.repository.impl;

import com.lth.pojos.Trip;
import com.lth.repository.TripRepository;
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
public class TripRepositoryImpl implements TripRepository {
    @Autowired
    private LocalSessionFactoryBean sessionFactory;

    @Override
    public List<Trip> getTrips() {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Trip> query = builder.createQuery(Trip.class);
        Root<Trip> tripRoot = query.from(Trip.class);
        query.select(tripRoot);

        return null;
    }

    @Override
    public boolean addTrip(Trip trip) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        try {
            session.save(trip);
            return true;
        } catch (Exception ex) {
            System.err.println("ADD TRIP ERROR!" + ex.getMessage());
            ex.printStackTrace();
        }

        return false;
    }

    @Override
    public boolean checkTripIsNotExist(Trip trip) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Trip> criteriaQuery = builder.createQuery(Trip.class);
        Root<Trip> tripRoot = criteriaQuery.from(Trip.class);
        criteriaQuery.select(tripRoot);

        Predicate predicate1 = builder.equal(tripRoot.get("departureProvince").get("id").as(Long.class), trip.getDepartureProvince().getId());
        Predicate predicate2 = builder.equal(tripRoot.get("destinationProvince").get("id").as(Long.class), trip.getDestinationProvince().getId());
        criteriaQuery = criteriaQuery.where(builder.and(predicate1, predicate2));
        Query query = session.createQuery(criteriaQuery);

        if(query.getSingleResult() == null)
            return true;

        return false;
    }

    @Override
    public Trip findTrip(Trip trip) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Trip> criteriaQuery = builder.createQuery(Trip.class);
        Root<Trip> tripRoot = criteriaQuery.from(Trip.class);
        criteriaQuery.select(tripRoot);

        Predicate predicate1 = builder.equal(tripRoot.get("departureProvince").get("id").as(Long.class), trip.getDepartureProvince().getId());
        Predicate predicate2 = builder.equal(tripRoot.get("destinationProvince").get("id").as(Long.class), trip.getDestinationProvince().getId());
        criteriaQuery = criteriaQuery.where(builder.and(predicate1, predicate2));
        Query query = session.createQuery(criteriaQuery);

        return (Trip) query.getSingleResult();
    }
}
