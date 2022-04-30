package com.lth.repository.impl;

import com.lth.pojos.Surcharge;
import com.lth.repository.SurchangeRepository;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

@Repository
@Transactional
public class SurchangeRepositoryImpl implements SurchangeRepository {
    @Autowired
    private LocalSessionFactoryBean sessionFactory;

    @Override
    public List<Surcharge> getSurchange() {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Surcharge> criteriaQuery = builder.createQuery(Surcharge.class);
        Root<Surcharge> root = criteriaQuery.from(Surcharge.class);
        criteriaQuery = criteriaQuery.select(root);

        Query query = session.createQuery(criteriaQuery);

        return query.getResultList();
    }
}
