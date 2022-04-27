package com.lth.controllers.admin;

import com.lth.pojos.Tour;
import com.lth.pojos.User;
import com.lth.service.EmployeeService;
import com.lth.service.TourService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Controller
@PropertySource("classpath:pagination.properties")
@RequestMapping("admin")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private Environment env;


    @RequestMapping(value ="/employee" ,method = RequestMethod.GET)
    public String getEmployeeP(ModelMap modelMap,
                          @RequestParam(required = false) Map<String, String> params) {
        int pageNumberOfTour = Integer.parseInt(env.getProperty("pagination.numberOfTour"));
        String keyword = params.getOrDefault("kw", "");
        int page = Integer.parseInt(params.getOrDefault("page", "1"));

        modelMap.addAttribute("employees",
                this.employeeService.getEmployees(keyword, page));
        modelMap.put("numberOfTourPaginationItem",
                this.employeeService.countEmployee() / pageNumberOfTour);
        return "admin.index.employee";
    }

    @RequestMapping(value ="/employee/form", method = RequestMethod.GET)
    public String formEmployeeP(ModelMap modelMap) {
        modelMap.put("tour", new Tour());
        modelMap.put("valueButton", "Lưu");
        return "admin.index.employee.form";
    }

    @PostMapping("/employee/save")
    public String saveEmployeeP(ModelMap modelMap, @ModelAttribute(value = "employee")User employee) {
        int pageNumberOfTour = Integer.parseInt(env.getProperty("pagination.numberOfTour"));
        if(employee.getId() == 0) {
            employeeService.addEmployee(employee);
        } else {
            employeeService.updateEmployee(employee);
        }
        modelMap.put("employees",
                this.employeeService.getEmployees("", 1));
        modelMap.put("numberOfTourPaginationItem",
                this.employeeService.countEmployee() / pageNumberOfTour);

        return "admin.index.employee";
    }

    @RequestMapping (value ="/employee/edit/{employeeId}", method = RequestMethod.GET)
    public String editEmployeeP(ModelMap modelMap, @PathVariable("employeeId") int employeeId) {
        User employee = employeeService.findEmployeeById(employeeId);
        modelMap.put("valueButton", "Sửa");
        modelMap.put("employee", employee);
        return "admin.index.employee.form";
    }

    @RequestMapping (value ="/employee/delete/{employeeId}", method = RequestMethod.GET)
    public String deleteEmployeeP(ModelMap modelMap, @PathVariable("employeeId") int employeeId) {
        int pageNumberOfTour = Integer.parseInt(env.getProperty("pagination.numberOfTour"));
        User employee = employeeService.findEmployeeById(employeeId);
        if (employee != null) {
            employeeService.deleteEmployee(employee);
        }
        modelMap.put("employees",
                this.employeeService.getEmployees("", 1));
        modelMap.put("numberOfTourPaginationItem",
                this.employeeService.countEmployee() / pageNumberOfTour);
        return "admin.index.employee";
    }
}
