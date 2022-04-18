package com.lth.repository.impl;

import com.lth.pojos.News;
import com.lth.repository.NewsRepository;
import org.hibernate.HibernateException;
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
public class NewsRepositoryImpl implements NewsRepository {
    @Autowired
    private LocalSessionFactoryBean sessionFactory;

    @Override
    public List<News> getNews(String keyword, int page) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<News> criteriaQuery = builder.createQuery(News.class);
        Root<News> root = criteriaQuery.from(News.class);
        criteriaQuery = criteriaQuery.select(root);

        if (!keyword.isEmpty()) {
            Predicate predicate = builder.like(root.get("title").as(String.class),
                    String.format("%%%s%%", keyword));
            criteriaQuery.where(predicate);
        }

        Query query = session.createQuery(criteriaQuery);

        return query.getResultList();
    }

    @Override
    public long countNews() {
        return 0;
    }

    @Override
    public boolean addNews(News news) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        try {
            session.save(news);
            return true;
        } catch (HibernateException ex) {
            System.err.println(ex.getMessage());
        }
        return false;
    }

    @Override
    public boolean updateNews(News news) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        try {
            session.update(news);
            return true;
        } catch (HibernateException ex) {
            System.err.println(ex.getMessage());
        }
        return false;
    }

    @Override
    public boolean deleteNews(News news) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        try {
            session.delete(news);
            return true;
        } catch (HibernateException ex) {
            System.err.println(ex.getMessage());
        }
        return false;
    }
}
