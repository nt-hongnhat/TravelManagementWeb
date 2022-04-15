package com.lth.repository.impl;

import com.lth.pojos.Province;
import com.lth.repository.ProvinceRepository;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.Query;
import java.util.List;

@Repository
@Transactional
public class ProvinceRepositoryImpl implements ProvinceRepository {
    @Autowired
    private LocalSessionFactoryBean sessionFactoryBean;
    @Override
    public List<Province> getProvinces() {
        Session session = this.sessionFactoryBean.getObject().getCurrentSession();
        Query query= session.createQuery("From Province");
        return query.getResultList();
    }
}
