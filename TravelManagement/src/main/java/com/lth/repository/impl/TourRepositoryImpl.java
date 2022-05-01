/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lth.repository.impl;

import com.lth.pojos.Category;
import com.lth.pojos.Tour;
import com.lth.pojos.TourDeparture;
import com.lth.pojos.Trip;
import com.lth.repository.TourRepository;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author PC
 */
@Repository
@Transactional
@PropertySource("classpath:pagination.properties")
public class TourRepositoryImpl implements TourRepository {
    @Autowired
    private Environment env;
    @Autowired
    private LocalSessionFactoryBean sessionFactory;

    @Override
    public List<Tour> getTours(String keyword, int page) {
        int pageNumberOfTour = Integer.parseInt(env.getProperty("pagination.numberOfTour"));
        Session session = this.sessionFactory.getObject().getCurrentSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Tour> criteriaQuery = builder.createQuery(Tour.class);
        Root<Tour> root = criteriaQuery.from(Tour.class);
        criteriaQuery = criteriaQuery.select(root);

        if (!keyword.isEmpty()) {
            Predicate predicate = builder.like(root.get("name").as(String.class),
                    String.format("%%%s%%", keyword));
            criteriaQuery.where(predicate);
        }


        Query query = session.createQuery(criteriaQuery);
        query.setMaxResults(pageNumberOfTour);
        query.setFirstResult((page - 1) * pageNumberOfTour);

        return query.getResultList();
    }

    @Override
    public long countTour() {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        Query query = session.createQuery("SELECT Count(*) FROM Tour");

        return Long.parseLong(query.getSingleResult().toString());
    }

    @Override
    public boolean addTour(Tour tour) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        try {
            session.save(tour);
            return true;
        } catch (Exception ex) {
            System.err.println("ADD TOUR ERROR!" + ex.getMessage());
            ex.printStackTrace();
            System.err.println(ex);
        }

        return false;
    }

    public boolean updateTour(Tour tour) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        try {
            session.update(tour);
            return true;
        } catch (Exception ex) {
            System.err.println("UPDATE TOUR ERROR!" + ex.getMessage());
            ex.printStackTrace();
        }

        return false;
    }

    public boolean deleteTour(Tour tour) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        try {
            session.delete(tour);
            return true;
        } catch (Exception ex) {
            System.err.println("DELETE TOUR ERROR!" + ex.getMessage());
            ex.printStackTrace();
        }

        return false;
    }

    @Override
    public Tour findTourById(long tourId) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Tour> criteriaQuery = builder.createQuery(Tour.class);
        Root<Tour> root = criteriaQuery.from(Tour.class);
        criteriaQuery = criteriaQuery.select(root);

        if (tourId != -1) {
            Predicate predicate = builder.equal(root.get("id").as(Long.class), tourId);
            criteriaQuery.where(predicate);
        }

        Query query = session.createQuery(criteriaQuery);

        return (Tour) query.getSingleResult();
    }

    @Override
    public List<Tour> getTours(Map<String, String> params) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Object[]> criteriaQuery = builder.createQuery(Object[].class);
        Root<Tour> root = criteriaQuery.from(Tour.class);
        Root<TourDeparture> tourDepartureRoot = criteriaQuery.from(TourDeparture.class);
        Root<Category> categoryRoot = criteriaQuery.from(Category.class);
        Root<Trip> tripRoot = criteriaQuery.from(Trip.class);

        criteriaQuery.multiselect(root, categoryRoot, tourDepartureRoot, tripRoot);

        if (params != null) {
            List<Predicate> predicates = new ArrayList<>();
            if (params.containsKey("categoryId") == true) {
                Predicate predicate = builder.equal(root.get("category").get("id").as(String.class), params.get("categoryId"));
                predicates.add(predicate);
            }
            if (params.containsKey("departureDate") == true) {
                Predicate predicate = builder.equal(root.get("departure").as(Date.class), java.sql.Date.valueOf(params.get("departureDate")));
                predicates.add(predicate);
            }

            if (params.containsKey("departureProvince") == true) {
                Predicate predicate = builder.equal(root.get("departureProvince").get("name").as(String.class), params.get("departureProvince"));
                predicates.add(predicate);
            }

            if (params.containsKey("destinationProvince") == true) {
                Predicate predicate = builder.equal(root.get("destinationProvince").get("name").as(String.class), params.get("destinationProvince"));
                predicates.add(predicate);
            }
            criteriaQuery = criteriaQuery.where(predicates.toArray(new Predicate[]{}));
        }
        criteriaQuery = criteriaQuery.orderBy(builder.desc(root.get("id")));
        Query query = session.createQuery(criteriaQuery);
        return query.getResultList();
    }


}
