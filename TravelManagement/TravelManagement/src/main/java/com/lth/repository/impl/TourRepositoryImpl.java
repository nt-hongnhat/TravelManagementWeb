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
import java.math.BigDecimal;
import java.util.ArrayList;
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
    public List<Tour> getTours(Map<String, String> params, int page) {
        int pageNumberOfTour = Integer.parseInt(env.getProperty("pagination.numberOfTour"));
        Session session = this.sessionFactory.getObject().getCurrentSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Tour> criteriaQuery = builder.createQuery(Tour.class);
        Root<Tour> root = criteriaQuery.from(Tour.class);
        criteriaQuery.select(root);

        if (params != null) {
            List<Predicate> predicates = new ArrayList<>();
            if (params.containsKey("categoryId")) {
                Predicate predicate = builder.equal(root.get("category").get("id").as(Integer.class), Integer.parseInt(params.get("categoryId")));
                predicates.add(predicate);
            }

            //Tra cứu theo thời gian đi
            if (params.containsKey("durationId") == true) {
                Predicate predicate = builder.equal(root.get("duration").get("id").as(Integer.class), Integer.parseInt(params.get("durationId")));
                predicates.add(predicate);
            }

            //Tra cứu theo khoảng giá
            if (params.containsKey("rangePrice") == true) {
                Predicate predicate = null;
                switch (params.get("rangePrice")) {
                    case "1":
                        predicate = builder.lessThan(root.get("price").as(BigDecimal.class), BigDecimal.valueOf(2000000));
                        break;
                    case "2":
                        predicate = builder.between(root.get("price").as(BigDecimal.class), BigDecimal.valueOf(2000000), BigDecimal.valueOf(4000000));
                        break;
                    case "3":
                        predicate = builder.between(root.get("price").as(BigDecimal.class), BigDecimal.valueOf(4000000), BigDecimal.valueOf(6000000));
                        break;
                    case "4":
                        predicate = builder.between(root.get("price").as(BigDecimal.class), BigDecimal.valueOf(6000000), BigDecimal.valueOf(10000000));
                        break;
                    case "5":
                        predicate = builder.greaterThan(root.get("price").as(BigDecimal.class), BigDecimal.valueOf(10000000));
                        break;
                }
                predicates.add(predicate);
            }
//
//            //Tra cứu theo ngày khởi hành
//            if (params.containsKey("departureDate") == true) {
//                Date date= Date.valueOf(params.get("departureDate"));
//                TourDe
//                Predicate predicate =builder.;
////                predicates.add(predicate);
//            }

            //Tra cứu theo chuyến đi: tỉnh bắt đầu, tỉnh kết thúc
//            if (params.containsKey("departureProvince") == true) {
//                Predicate predicate = builder.equal(root.get("trip").get("destinationProvince").get("id").as(Integer.class), Integer.parseInt(params.get("departureProvince")));
//                predicates.add(predicate);
//            }
//
            //Tra cứu theo nơi đến: tỉnh thành phố
            if (params.containsKey("destinationProvince") == true) {
                Predicate predicate = builder.equal(root.get("trip").get("destinationProvince").get("id").as(Integer.class), Integer.parseInt(params.get("destinationProvince")));
                predicates.add(predicate);
            }

            criteriaQuery = criteriaQuery.where(builder.and(predicates.toArray(new Predicate[]{})));
        }

        criteriaQuery = criteriaQuery.orderBy(builder.desc(root.get("id")));

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
    public List<Tour> findAll(int page) {
        int pageNumberOfTour = Integer.parseInt(env.getProperty("pagination.numberOfTour"));
        Session session = this.sessionFactory.getObject().getCurrentSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Tour> criteriaQuery = builder.createQuery(Tour.class);
        Root<Tour> root = criteriaQuery.from(Tour.class);
        criteriaQuery.select(root);
        criteriaQuery.orderBy(builder.desc(root.get("id")));
        Query query = session.createQuery(criteriaQuery);
        query.setMaxResults(pageNumberOfTour);
        query.setFirstResult((page - 1) * pageNumberOfTour);
        return query.getResultList();
    }

}
