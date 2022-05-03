package com.lth.repository.impl;

import com.lth.pojos.Duration;
import com.lth.repository.DurationRepository;
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
public class DurationRepositoryImpl implements DurationRepository {
    @Autowired
    private LocalSessionFactoryBean sessionFactoryBean;

    @Override
    public List<Duration> getDurations(int quantityDays) {
        Session session = this.sessionFactoryBean.getObject().getCurrentSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Duration> criteriaQuery = builder.createQuery(Duration.class);
        Root<Duration> durationRoot = criteriaQuery.from(Duration.class);
        criteriaQuery = criteriaQuery.select(durationRoot);

        if (quantityDays > 0) {
            Predicate predicate = builder.equal(durationRoot.get("quantityDays").as(Integer.class), quantityDays);
            criteriaQuery.where(predicate);
        }

        Query query = session.createQuery(criteriaQuery);
        return query.getResultList();
    }

    @Override
    public Duration getDurationByID(int id) {
        Session session = this.sessionFactoryBean.getObject().getCurrentSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Duration> criteriaQuery = builder.createQuery(Duration.class);
        Root<Duration> durationRoot = criteriaQuery.from(Duration.class);
        criteriaQuery = criteriaQuery.select(durationRoot);

        Predicate predicate = builder.equal(durationRoot.get("id").as(Integer.class), id);
        criteriaQuery.where(predicate);

        Query query = session.createQuery(criteriaQuery);
        return (Duration) query.getSingleResult();
    }


    @Override
    public boolean addDuration(Duration duration) {
        Session session = this.sessionFactoryBean.getObject().getCurrentSession();
        try {
            session.save(duration);
            return true;
        } catch (Exception exception) {
            System.err.println("ADD DURATION ERROR!" + exception.getMessage());
            exception.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean updateDuration(Duration duration) {
        Session session = this.sessionFactoryBean.getObject().getCurrentSession();
        try {
            session.update(duration);
            return true;
        } catch (Exception exception) {
            System.err.println("UPDATE DURATION ERROR!" + exception.getMessage());
            exception.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean deleteDuration(Duration duration) {
        Session session = this.sessionFactoryBean.getObject().getCurrentSession();
        try {
            session.delete(duration);
            return true;
        } catch (Exception exception) {
            System.err.println("DELETE DURATION ERROR!" + exception.getMessage());
            exception.printStackTrace();
        }
        return false;
    }
}
