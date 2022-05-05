package com.lth.repository.impl;

import com.lth.pojos.TourPlace;
import com.lth.pojos.TourSchedule;
import com.lth.repository.TourScheduleRepository;
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
public class TourScheduleRepositoryImpl implements TourScheduleRepository {
    @Autowired
    private LocalSessionFactoryBean sessionFactory;

    @Override
    public List<TourSchedule> findTourScheduleByTourId(long tourId) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<TourSchedule> criteriaQuery = builder.createQuery(TourSchedule.class);
        Root<TourSchedule> root = criteriaQuery.from(TourSchedule.class);
        criteriaQuery = criteriaQuery.select(root);


        if (tourId != -1) {
            Predicate predicate = builder.equal(root.get("tour").get("id").as(Long.class), tourId);
            criteriaQuery.where(predicate);
        }

        Query query = session.createQuery(criteriaQuery);

        return query.getResultList();
    }
}
