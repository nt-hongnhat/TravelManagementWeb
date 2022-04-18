package com.lth.repository;

import com.lth.pojos.User;

import java.util.List;

public interface EmployeeRepository {
    List<User> getEmployee(String keyword, int page);
    long countEmployee();
    boolean addEmployee(User user);
    boolean updateEmployee(User user);
    boolean deleteEmployee(User user);
}
