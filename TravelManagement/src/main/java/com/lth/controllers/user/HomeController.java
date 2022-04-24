/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lth.controllers.user;

import com.lth.service.CategoryService;
import com.lth.service.ProvinceService;
import com.lth.service.TourService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
<<<<<<< HEAD:TravelManagement/src/main/java/com/lth/controllers/HomeController.java
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;
=======
import org.springframework.web.bind.annotation.GetMapping;
>>>>>>> 67f53234a827a8d01125e68f8f4a1dd4a02ebe1d:TravelManagement/src/main/java/com/lth/controllers/user/HomeController.java
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

/**
 * @author PC
 */
@Controller
<<<<<<< HEAD:TravelManagement/src/main/java/com/lth/controllers/HomeController.java
@ControllerAdvice
=======
@RequestMapping("")
>>>>>>> 67f53234a827a8d01125e68f8f4a1dd4a02ebe1d:TravelManagement/src/main/java/com/lth/controllers/user/HomeController.java
public class HomeController {
    @Autowired
    private CategoryService categoryService;
    @Autowired
    private TourService tourService;
    @Autowired
    private ProvinceService provinceService;

    @ModelAttribute
    public void commonAttributes(Model model) {
        model.addAttribute("categories", this.categoryService.getCategories());
        model.addAttribute("provinces", this.provinceService.getProvinces());

    }


    @RequestMapping("/")
    public String index(Model model,
                        @RequestParam(required = false) Map<String, String> params) {
        int page = Integer.parseInt(params.getOrDefault("page", "1"));

        String keyword = params.getOrDefault("kw", null);
        model.addAttribute("tours", this.tourService.getTours(keyword, page));

        model.addAttribute("numberOfTour",
                this.tourService.countTour());
        return "index";
    }

	@RequestMapping(value = "/403", method = RequestMethod.GET)
	public String accessDenied() {
		return "403";
	}

}
