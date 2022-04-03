/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lth.repository.impl;

import com.lth.pojos.Tour;
import com.lth.repository.TourRepository;
import java.util.List;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author PC
 */
@Repository
@Transactional
@PropertySource("classpath:pagination.properties")
public class TourRepositoryImpl implements TourRepository{
    @Autowired
    private LocalSessionFactoryBean sessionFactory;
    
    @Override
    public List<Tour> getTours(String keyword, int page) {
        int maxSizePage = 6;
        Session session = this.sessionFactory.getObject().getCurrentSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Tour> query = builder.createQuery(Tour.class);
        Root root = query.from(Tour.class);
        query.select(root);
        
        if (keyword.isEmpty() && keyword != null) {
            Predicate predicate = builder.like(root.get("name").as(String.class),
                    String.format("%%%s%%", keyword));
            query.where(predicate);
        }
        
        Query q = session.createQuery(query);
        q.setMaxResults(maxSizePage);
        q.setFirstResult((page-1) * maxSizePage);
        
        return q.getResultList();
    }

    @Override
    public long countTour() {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        Query query = session.createQuery("SELECT Count(*) FROM Tour");
        
        return Long.parseLong(query.getSingleResult().toString());
    }
    
}
