/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lth.controllers;

import com.lth.service.CategoryService;
import com.lth.service.ProvinceService;
import com.lth.service.TourService;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author PC
 */
@Controller
@ControllerAdvice
public class HomeController {
	@Autowired
	private CategoryService categoryService;
	@Autowired
	private TourService tourService;
	@Autowired
	private ProvinceService provinceService;

	@ModelAttribute
	public void commonAttributes(Model model){
		model.addAttribute("categories", this.categoryService.getCategories());
	}


	@RequestMapping("/")
	public String index(Model model,
						@RequestParam(required = false) Map<String, String> params) {
		String keyword = params.getOrDefault("kw", "");
		int page = Integer.parseInt(params.getOrDefault("page", "1"));

		model.addAttribute("tours",
				this.tourService.getTours(keyword, page));
		model.addAttribute("numberOfTour",
				this.tourService.countTour());
		model.addAttribute("provinces", this.provinceService.getProvinces());
		model.addAttribute("toursByCate", this.tourService.getToursByCategory(1));
		return "index";
	}

}
