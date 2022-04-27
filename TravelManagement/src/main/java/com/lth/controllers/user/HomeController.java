/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lth.controllers.user;

import com.lth.service.CategoryService;
import com.lth.service.ProvinceService;
import com.lth.service.TourService;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 * @author PC
 */
@Controller
@ControllerAdvice
@PropertySource("classpath:pagination.properties")
@RequestMapping("")
public class HomeController {
	@Autowired
	private Environment env;
	@Autowired
	private CategoryService categoryService;
	@Autowired
	private TourService tourService;
	@Autowired
	private ProvinceService provinceService;

	@ModelAttribute
	public void commonAttributes(Model model){
		model.addAttribute("categories", this.categoryService.getCategories());
		model.addAttribute("provinces", this.provinceService.getProvinces());
	}

	@RequestMapping("/")
	public String index(Model model,
						@RequestParam(required = false) Map<String, String> params) {
		String keyword = params.getOrDefault("kw", "");
		int page = Integer.parseInt(params.getOrDefault("page", "1"));
		int pageNumberOfTour = Integer.parseInt(env.getProperty("pagination.numberOfTour"));

		model.addAttribute("tours",
				this.tourService.getTours(keyword, page));
		model.addAttribute("numberOfTourPaginationItem",
				this.tourService.countTour() / pageNumberOfTour);
		model.addAttribute("provinces", this.provinceService.getProvinces());
		model.addAttribute("categories", this.categoryService.getCategories());
		return "index";
	}

	@RequestMapping(value = "/403", method = RequestMethod.GET)
	public String accessDenied() {
		return "403";
	}

}
