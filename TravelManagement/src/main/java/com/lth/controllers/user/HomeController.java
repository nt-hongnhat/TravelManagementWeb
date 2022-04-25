/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lth.controllers.user;

import com.lth.service.CategoryService;
import com.lth.service.NewsService;
import com.lth.service.ProvinceService;
import com.lth.service.TourService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * @author PC
 */
@Controller
@ControllerAdvice
@RequestMapping("")
public class HomeController {
    @Autowired
    private CategoryService categoryService;
    @Autowired
    private TourService tourService;
    @Autowired
    private ProvinceService provinceService;
    @Autowired
    private NewsService newsService;

    @ModelAttribute
    public void commonAttributes(Model model) {
        model.addAttribute("categories", this.categoryService.getCategories());
        model.addAttribute("provinces", this.provinceService.getProvinces());
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
        model.addAttribute("news", this.newsService.getNews("", page));
        return "index";
    }

    @RequestMapping(value = "/403", method = RequestMethod.GET)
    public String accessDenied() {
        return "403";
    }

}
