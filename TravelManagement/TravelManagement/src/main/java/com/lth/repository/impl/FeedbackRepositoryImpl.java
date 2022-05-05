package com.lth.repository.impl;

import com.lth.pojos.Feedback;
import com.lth.pojos.TourSchedule;
import com.lth.repository.FeedbackRepository;
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
import java.math.BigDecimal;

@Repository
@Transactional
public class FeedbackRepositoryImpl implements FeedbackRepository {
    @Autowired
    private LocalSessionFactoryBean sessionFactory;

    @Override
    public Object[] getRatingByTourId(int tourId) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Object[]> criteriaQuery = builder.createQuery(Object[].class);
        Root<Feedback> root = criteriaQuery.from(Feedback.class);
        criteriaQuery.multiselect(builder.count(root.get("id")),builder.avg(root.get("rating").as(BigDecimal.class)));

        if (tourId != -1) {
            Predicate predicate = builder.equal(root.get("tour").get("id").as(Long.class), tourId);
            criteriaQuery.where(predicate);
        }

        Query query = session.createQuery(criteriaQuery);

        return (Object[]) query.getSingleResult();
    }
}
