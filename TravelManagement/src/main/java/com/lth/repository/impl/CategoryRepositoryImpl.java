package com.lth.repository.impl;

import com.lth.pojos.Category;
import com.lth.repository.CategoryRepository;
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
public class CategoryRepositoryImpl implements CategoryRepository {
    @Autowired
    private LocalSessionFactoryBean sessionFactoryBean;

    @Override
    public List<Category> getCategories() {
        Session session = sessionFactoryBean.getObject().getCurrentSession();
        Query query = session.createQuery("From Category");
        return query.getResultList();
    }

    @Override
    public Category getCategoryByID(int id) {
        Session session = this.sessionFactoryBean.getObject().getCurrentSession();
        CriteriaBuilder builder= session.getCriteriaBuilder();
        CriteriaQuery<Category> criteriaQuery= builder.createQuery(Category.class);
        Root<Category> root= criteriaQuery.from(Category.class);
        criteriaQuery.select(root);
        criteriaQuery.where(builder.equal(root.get("id"),id));
        Query query= session.createQuery(criteriaQuery);
        return (Category) query;
    }
}

