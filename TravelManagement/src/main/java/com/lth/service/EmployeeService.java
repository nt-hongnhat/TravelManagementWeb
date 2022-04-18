package com.lth.service;

import com.lth.pojos.User;

import java.util.List;

public interface EmployeeService {
    List<User> getEmployee(String customer, int page);
    long countEmployee();
    boolean addEmployee(User user);
    boolean updateEmployee(User user);
    boolean deleteEmployee(User user);
}
