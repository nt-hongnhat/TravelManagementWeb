package com.lth.service.impl;

import com.lth.pojos.User;
import com.lth.pojos.UserRole;
import com.lth.repository.EmployeeRepository;
import com.lth.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public List<User> getEmployees(String username, int page) {
        return employeeRepository.getEmployees(username, page);
    }

    @Override
    public long countEmployee() {
        return 0;
    }

    @Override
    public boolean addEmployee(User user) {
        String password = user.getPassword();
        user.setPassword(this.bCryptPasswordEncoder.encode(password));
        user.setUserRole(String.valueOf(UserRole.EMPLOYEE));
        user.setCreatedDate(new Date());
        user.setUpdatedDate(new Date());
        return employeeRepository.addEmployee(user);
    }

    @Override
    public boolean updateEmployee(User user) {
        String password = user.getPassword();
        user.setPassword(this.bCryptPasswordEncoder.encode(password));
        return employeeRepository.updateEmployee(user);
    }

    @Override
    public boolean deleteEmployee(User user) {
        return employeeRepository.deleteEmployee(user);
    }

    @Override
    public User findEmployeeById(long employeeId) {
        return employeeRepository.findEmployeeById(employeeId);
    }

}
