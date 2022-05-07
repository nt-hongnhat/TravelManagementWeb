package com.lth.repository.impl;

import com.lth.pojos.*;
import com.lth.repository.LocationProvinceRepository;
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
public class LocationProvinceRepositoryImpl implements LocationProvinceRepository {
    @Autowired
    private LocalSessionFactoryBean sessionFactory;

    @Override
    public List<Province> getProvince() {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Province> criteriaQuery = builder.createQuery(Province.class);
        Root<Province> root = criteriaQuery.from(Province.class);
        criteriaQuery = criteriaQuery.select(root);


        Query query = session.createQuery(criteriaQuery);

        return query.getResultList();
    }

    @Override
    public Province findProvinceById(long provinceId) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Province> criteriaQuery = builder.createQuery(Province.class);
        Root<Province> root = criteriaQuery.from(Province.class);
        criteriaQuery = criteriaQuery.select(root);

        if (provinceId != -1) {
            Predicate predicate = builder.equal(root.get("id").as(Long.class), provinceId);
            criteriaQuery.where(predicate);
        }

        Query query = session.createQuery(criteriaQuery);

        return (Province) query.getSingleResult();
    }
}
