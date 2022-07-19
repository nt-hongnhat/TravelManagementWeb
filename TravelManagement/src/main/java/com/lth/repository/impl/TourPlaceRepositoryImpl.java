package com.lth.repository.impl;

import com.lth.pojos.TourPlace;
import com.lth.repository.TourPlaceRepository;
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
public class TourPlaceRepositoryImpl implements TourPlaceRepository {
    @Autowired
    private LocalSessionFactoryBean sessionFactory;

    @Override
    public List<TourPlace> findTourPlaceByTourId(long tourId) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<TourPlace> criteriaQuery = builder.createQuery(TourPlace.class);
        Root<TourPlace> root = criteriaQuery.from(TourPlace.class);
        criteriaQuery = criteriaQuery.select(root);


        if (tourId != -1) {
            Predicate predicate = builder.equal(root.get("tour").get("id").as(Long.class), tourId);
            criteriaQuery.where(predicate);
        }

        criteriaQuery.orderBy(builder.asc(root.get("places")));
        Query query = session.createQuery(criteriaQuery);

        return query.getResultList();
    }
}
