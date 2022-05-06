package com.lth.controllers.admin;

import com.lth.pojos.Tour;
import com.lth.pojos.User;
import com.lth.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.persistence.NoResultException;
import javax.validation.Valid;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Controller
@PropertySource("classpath:pagination.properties")
@RequestMapping("admin")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private Environment env;

    @InitBinder("employee")
    public void initBinder(WebDataBinder binder) {
        SimpleDateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd");
        dateFormatter.setLenient(false);
        binder.registerCustomEditor(Date.class, "dayOfBirth",
                new CustomDateEditor(dateFormatter, true));
    }

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
        modelMap.put("employee", new User());
        modelMap.put("valueButton", "Lưu");
        return "admin.index.employee.form";
    }

    @PostMapping("/employee/save")
    public String saveEmployeeP(ModelMap modelMap,@Valid @ModelAttribute(value = "employee")User employee,
                                BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            modelMap.put("valueButton", "Thực thi");
            modelMap.put("employee", employee);
            return "admin.index.employee.form";
        }

        if(employee.getId() == 0) {
            List<User> checkEmployee = employeeService.getEmployees(employee.getUsername(),1);
            if (checkEmployee.size() > 0 && checkEmployee.get(0) != null) {
                modelMap.put("message", "Tài khoản đã bị trùng");
                modelMap.put("valueButton", "Lưu");
            }
            employeeService.addEmployee(employee);
        } else {
            employeeService.updateEmployee(employee);
        }

        return "redirect:/admin/employee";
    }

    @RequestMapping (value ="/employee/edit/{employeeId}", method = RequestMethod.GET)
    public String editEmployeeP(ModelMap modelMap, @PathVariable("employeeId") int employeeId) {
        User employee = employeeService.findEmployeeById(employeeId);
        modelMap.put("valueButton", "Sửa");
        modelMap.put("isUpdate", true);
        modelMap.put("employee", employee);
        return "admin.index.employee.form";
    }

    @RequestMapping (value ="/employee/delete/{employeeId}", method = RequestMethod.GET)
    public String deleteEmployeeP(ModelMap modelMap, @PathVariable("employeeId") int employeeId) {
        User employee = employeeService.findEmployeeById(employeeId);

        if (employee != null) {
            employeeService.deleteEmployee(employee);
        }

        return "redirect:/admin/employee";
    }
}
