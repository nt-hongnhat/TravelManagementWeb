package com.lth.service.impl;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.lth.pojos.User;
import com.lth.pojos.UserRole;
import com.lth.repository.EmployeeRepository;
import com.lth.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    @Autowired
    private Cloudinary cloudinary;

    @Override
    public List<User> getEmployees(String username, int page) {
        return employeeRepository.getEmployees(username, page);
    }

    @Override
    public long countEmployee() {
        return 0;
    }

    @Override
    public boolean addEmployee(User user) {  String password = user.getPassword();
        user.setPassword(this.bCryptPasswordEncoder.encode(password));
        user.setUserRole(String.valueOf(UserRole.EMPLOYEE));
        user.setCreatedDate(new Date());
        user.setUpdatedDate(new Date());
        user.setAvatar("hello");
        return employeeRepository.addEmployee(user);

//        try {
//            String password = user.getPassword();
//            user.setPassword(this.bCryptPasswordEncoder.encode(password));
//            user.setUserRole(String.valueOf(UserRole.EMPLOYEE));
//            user.setCreatedDate(new Date());
//            user.setUpdatedDate(new Date());
//            Map map = this.cloudinary.uploader().upload(user.getFile().getBytes(), ObjectUtils.asMap("resource_type", "auto"));
//            user.setAvatar((String) map.get("secure_url"));
//            user.setAvatar("hello");
//            return employeeRepository.addEmployee(user);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        return false;
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
