package com.lth.repository.impl;

import com.lth.pojos.Category;
import com.lth.repository.CategoryRepository;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.Query;
import java.util.List;

@Repository
@Transactional
public class CategoryRepositoryImpl implements CategoryRepository {
    @Autowired
    private LocalSessionFactoryBean sessionFactoryBean;

    @Override
    public List<Category> getCategories() {
        Session session = sessionFactoryBean.getObject().getCurrentSession();
        Query query = session.createQuery("From Category");
        return query.getResultList();
    }
}
