package com.lth.repository.impl;

import com.lth.pojos.User;
import com.lth.pojos.UserInfo;
import com.lth.pojos.UserRole;
import com.lth.repository.EmployeeRepository;
import org.hibernate.Criteria;
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
public class EmployeeRepositoryImpl implements EmployeeRepository {
    @Autowired
    private LocalSessionFactoryBean sessionFactory;

    @Override
    public List<User> getEmployees(String username, int page) {
        Session session = sessionFactory.getObject().getCurrentSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Object[]> criteriaQuery = builder.createQuery(Object[].class);
        Root<User> rootUser = criteriaQuery.from(User.class);
        Root<UserInfo> rootUserInfo = criteriaQuery.from(UserInfo.class);
        criteriaQuery.where(builder.equal(rootUser.get("userInfoId"), rootUserInfo.get("id")));
        criteriaQuery.multiselect(rootUser);
        Predicate predicateCustomer = builder.equal(rootUser.get("userRole").as(String.class), UserRole.EMPLOYEE.toString());
        criteriaQuery.where(predicateCustomer);

        if(!username.isEmpty()) {
            Predicate predicate = builder.equal(rootUser.get("username").as(String.class), username.trim());
            criteriaQuery = criteriaQuery.where(predicate);
        }

        Query query = session.createQuery(criteriaQuery).setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
        return query.getResultList();
    }

    @Override
    public long countEmployee() {
        return 0;
    }

    @Override
    public boolean addEmployee(User user) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        try {
            session.save(user);
            return true;
        } catch (Exception ex) {
            System.err.println("ADD TOUR ERROR!" + ex.getMessage());
            ex.printStackTrace();
        }

        return false;
    }

    @Override
    public boolean updateEmployee(User user) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        try {
            session.update(user);
            return true;
        } catch (Exception ex) {
            System.err.println("ADD TOUR ERROR!" + ex.getMessage());
            ex.printStackTrace();
        }

        return false;
    }

    @Override
    public boolean deleteEmployee(User user) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        try {
            session.delete(user);
            return true;
        } catch (Exception ex) {
            System.err.println("ADD TOUR ERROR!" + ex.getMessage());
            ex.printStackTrace();
        }

        return false;
    }

    @Override
    public User findEmployeeById(long employeeId) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<User> criteriaQuery = builder.createQuery(User.class);
        Root<User> root = criteriaQuery.from(User.class);
        criteriaQuery = criteriaQuery.select(root);

        if (employeeId != -1) {
            Predicate predicate = builder.equal(root.get("id").as(Long.class), employeeId);
            criteriaQuery.where(predicate);
        }

        Query query = session.createQuery(criteriaQuery);

        return (User) query.getSingleResult();
    }
}
