package com.lth.repository.impl;

import com.lth.pojos.Province;
import com.lth.repository.ProvinceRepository;
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
public class ProvinceRepositoryImpl implements ProvinceRepository {
    @Autowired
    private LocalSessionFactoryBean sessionFactoryBean;

    @Override
    public List<Province> getProvinces(String name) {
        Session session = this.sessionFactoryBean.getObject().getCurrentSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Province> criteriaQuery = builder.createQuery(Province.class);
        Root<Province> provinceRoot = criteriaQuery.from(Province.class);
        criteriaQuery.select(provinceRoot);

        if (!name.isEmpty()) {
            Predicate predicate = builder.like(provinceRoot.get("name").as(String.class), String.format("%%%s%%%", name));
            criteriaQuery.where(predicate);
        }
        criteriaQuery.orderBy(builder.asc(provinceRoot.get("id")));

        Query query = session.createQuery(criteriaQuery);
        return query.getResultList();
    }

    @Override
    public Province findProvinceById(int id) {
        Session session = this.sessionFactoryBean.getObject().getCurrentSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Province> criteriaQuery = builder.createQuery(Province.class);
        Root<Province> provinceRoot = criteriaQuery.from(Province.class);
        criteriaQuery.select(provinceRoot);

        Predicate predicate = builder.equal(provinceRoot.get("id").as(Integer.class), id);
        criteriaQuery.where(predicate);

        Query query = session.createQuery(criteriaQuery);
        return (Province) query.getSingleResult();
    }

    @Override
    public boolean updateProvince(Province province) {
        Session session = this.sessionFactoryBean.getObject().getCurrentSession();
        try {
            session.update(province);
            return true;
        } catch (Exception exception) {
            System.err.println("UPDATE PROVINCE ERROR!" + exception.getMessage());
            exception.printStackTrace();
        }
        return false;
    }
}
